package org.jose4j.jwk;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import org.jose4j.http.Get;
import org.jose4j.http.SimpleGet;
import org.jose4j.http.SimpleResponse;
import org.jose4j.lang.ExceptionHelp;
import org.jose4j.lang.JoseException;
import org.shaded.apache.http.cookie.ClientCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpsJwks {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) HttpsJwks.class);
    private volatile Cache cache;
    private volatile long defaultCacheDuration = 3600;
    private final String location;
    private final ReentrantLock refreshLock;
    private long refreshReprieveThreshold;
    private volatile long retainCacheOnErrorDurationMills;
    private volatile SimpleGet simpleHttpGet;

    public HttpsJwks(String location2) {
        SimpleGet simpleGet;
        Cache cache2;
        ReentrantLock reentrantLock;
        new Get();
        this.simpleHttpGet = simpleGet;
        this.retainCacheOnErrorDurationMills = 0;
        new Cache(Collections.emptyList(), 0, (AnonymousClass1) null);
        this.cache = cache2;
        new ReentrantLock();
        this.refreshLock = reentrantLock;
        this.refreshReprieveThreshold = 300;
        this.location = location2;
    }

    public void setDefaultCacheDuration(long defaultCacheDuration2) {
        long j = defaultCacheDuration2;
        this.defaultCacheDuration = j;
    }

    public void setRetainCacheOnErrorDuration(long retainCacheOnErrorDuration) {
        long j = retainCacheOnErrorDuration * 1000;
        this.retainCacheOnErrorDurationMills = j;
    }

    public void setSimpleHttpGet(SimpleGet simpleHttpGet2) {
        SimpleGet simpleGet = simpleHttpGet2;
        this.simpleHttpGet = simpleGet;
    }

    public String getLocation() {
        return this.location;
    }

    public void setRefreshReprieveThreshold(long refreshReprieveThreshold2) {
        long j = refreshReprieveThreshold2;
        this.refreshReprieveThreshold = j;
    }

    public List<JsonWebKey> getJsonWebKeys() throws JoseException, IOException {
        Cache cache2;
        Cache c;
        Object obj;
        long now = System.currentTimeMillis();
        Cache c2 = this.cache;
        if (c2.exp > now) {
            return c2.keys;
        }
        if (!this.refreshLock.tryLock()) {
            if (!c2.keys.isEmpty()) {
                return c2.keys;
            }
            this.refreshLock.lock();
        }
        try {
            refresh();
            c = this.cache;
            this.refreshLock.unlock();
        } catch (Exception e) {
            Exception e2 = e;
            if (this.retainCacheOnErrorDurationMills <= 0 || c2.keys.isEmpty()) {
                throw e2;
            }
            new Cache(c2.keys, now + this.retainCacheOnErrorDurationMills, (AnonymousClass1) null);
            Cache cache3 = cache2;
            c = cache3;
            this.cache = cache3;
            Logger logger = log;
            Object[] objArr = new Object[5];
            objArr[0] = ExceptionHelp.toStringWithCauses(e2);
            Object[] objArr2 = objArr;
            objArr2[1] = this.location;
            Object[] objArr3 = objArr2;
            objArr3[2] = Long.valueOf(this.retainCacheOnErrorDurationMills / 1000);
            Object[] objArr4 = objArr3;
            new Date(c.exp);
            objArr4[3] = obj;
            Object[] objArr5 = objArr4;
            objArr5[4] = c.keys;
            logger.info("Because of {} unable to refresh JWKS content from {} so will continue to use cached keys for more {} seconds until about {} -> {}", objArr5);
            this.refreshLock.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.refreshLock.unlock();
            throw th2;
        }
        return c.keys;
    }

    public void refresh() throws JoseException, IOException {
        JsonWebKeySet jwks;
        Object obj;
        Cache cache2;
        this.refreshLock.lock();
        try {
            long last = System.currentTimeMillis() - this.cache.created;
            if (last >= this.refreshReprieveThreshold || this.cache.keys.isEmpty()) {
                log.debug("Refreshing/loading JWKS from {}", (Object) this.location);
                SimpleResponse simpleResponse = this.simpleHttpGet.get(this.location);
                new JsonWebKeySet(simpleResponse.getBody());
                List<JsonWebKey> keys = jwks.getJsonWebKeys();
                long cacheLife = getCacheLife(simpleResponse);
                if (cacheLife <= 0) {
                    log.debug("Will use default cache duration of {} seconds for content from {}", (Object) Long.valueOf(this.defaultCacheDuration), (Object) this.location);
                    cacheLife = this.defaultCacheDuration;
                }
                long exp = System.currentTimeMillis() + (cacheLife * 1000);
                Logger logger = log;
                Object[] objArr = new Object[4];
                objArr[0] = this.location;
                Object[] objArr2 = objArr;
                objArr2[1] = Long.valueOf(cacheLife);
                Object[] objArr3 = objArr2;
                new Date(exp);
                objArr3[2] = obj;
                Object[] objArr4 = objArr3;
                objArr4[3] = keys;
                logger.debug("Updated JWKS content from {} will be cached for {} seconds until about {} -> {}", objArr4);
                new Cache(keys, exp, (AnonymousClass1) null);
                this.cache = cache2;
            } else {
                log.debug("NOT refreshing/loading JWKS from {} because it just happened {} mills ago", (Object) this.location, (Object) Long.valueOf(last));
            }
            this.refreshLock.unlock();
        } catch (Throwable th) {
            Throwable th2 = th;
            this.refreshLock.unlock();
            throw th2;
        }
    }

    static long getDateHeaderValue(SimpleResponse response, String headerName, long j) {
        StringBuilder sb;
        long defaultValue = j;
        Iterator i$ = getHeaderValues(response, headerName).iterator();
        while (i$.hasNext()) {
            String value = i$.next();
            try {
                if (!value.endsWith("GMT")) {
                    new StringBuilder();
                    value = sb.append(value).append(" GMT").toString();
                }
                return Date.parse(value);
            } catch (Exception e) {
                Exception exc = e;
            }
        }
        return defaultValue;
    }

    private static List<String> getHeaderValues(SimpleResponse response, String headerName) {
        List<String> values = response.getHeaderValues(headerName);
        return values == null ? Collections.emptyList() : values;
    }

    static long getExpires(SimpleResponse response) {
        return getDateHeaderValue(response, ClientCookie.EXPIRES_ATTR, 0);
    }

    static long getCacheLife(SimpleResponse response) {
        return getCacheLife(response, System.currentTimeMillis());
    }

    static long getCacheLife(SimpleResponse simpleResponse, long currentTime) {
        SimpleResponse response = simpleResponse;
        long life = (getExpires(response) - currentTime) / 1000;
        Iterator i$ = getHeaderValues(response, "cache-control").iterator();
        while (true) {
            if (!i$.hasNext()) {
                break;
            }
            String value = i$.next();
            String value2 = value == null ? "" : value.toLowerCase();
            try {
                int indexOfMaxAge = value2.indexOf(ClientCookie.MAX_AGE_ATTR);
                int indexOfComma = value2.indexOf(44, indexOfMaxAge);
                String part = value2.substring(indexOfMaxAge, indexOfComma == -1 ? value2.length() : indexOfComma);
                life = Long.parseLong(part.substring(part.indexOf(61) + 1).trim());
            } catch (Exception e) {
                Exception exc = e;
            }
        }
        return life;
    }

    private static class Cache {
        /* access modifiers changed from: private */
        public final long created;
        /* access modifiers changed from: private */
        public final long exp;
        /* access modifiers changed from: private */
        public final List<JsonWebKey> keys;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        /* synthetic */ Cache(List x0, long x1, AnonymousClass1 r14) {
            this(x0, x1);
            AnonymousClass1 r4 = r14;
        }

        private Cache(List<JsonWebKey> keys2, long exp2) {
            this.created = System.currentTimeMillis();
            this.keys = keys2;
            this.exp = exp2;
        }
    }
}
