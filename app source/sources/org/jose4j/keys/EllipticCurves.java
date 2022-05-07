package org.jose4j.keys;

import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.HashMap;
import java.util.Map;

public class EllipticCurves {
    private static final int COFACTOR = 1;
    public static final ECParameterSpec P256;
    public static final ECParameterSpec P384;
    public static final ECParameterSpec P521;
    public static final String P_256 = "P-256";
    public static final String P_384 = "P-384";
    public static final String P_521 = "P-521";
    private static final Map<EllipticCurve, String> curveToName;
    private static final Map<String, ECParameterSpec> nameToSpec;

    public EllipticCurves() {
    }

    static {
        Map<String, ECParameterSpec> map;
        Map<EllipticCurve, String> map2;
        ECParameterSpec eCParameterSpec;
        EllipticCurve ellipticCurve;
        ECField eCField;
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        ECPoint eCPoint;
        BigInteger bigInteger4;
        BigInteger bigInteger5;
        BigInteger bigInteger6;
        ECParameterSpec eCParameterSpec2;
        EllipticCurve ellipticCurve2;
        ECField eCField2;
        BigInteger bigInteger7;
        BigInteger bigInteger8;
        BigInteger bigInteger9;
        ECPoint eCPoint2;
        BigInteger bigInteger10;
        BigInteger bigInteger11;
        BigInteger bigInteger12;
        ECParameterSpec eCParameterSpec3;
        EllipticCurve ellipticCurve3;
        ECField eCField3;
        BigInteger bigInteger13;
        BigInteger bigInteger14;
        BigInteger bigInteger15;
        ECPoint eCPoint3;
        BigInteger bigInteger16;
        BigInteger bigInteger17;
        BigInteger bigInteger18;
        new HashMap();
        nameToSpec = map;
        new HashMap();
        curveToName = map2;
        new BigInteger("115792089210356248762697446949407573530086143415290314195533631308867097853951");
        new ECFieldFp(bigInteger);
        new BigInteger("115792089210356248762697446949407573530086143415290314195533631308867097853948");
        new BigInteger("41058363725152142129326129780047268409114441015993725554835256314039467401291");
        new EllipticCurve(eCField, bigInteger2, bigInteger3);
        new BigInteger("48439561293906451759052585252797914202762949526041747995844080717082404635286");
        new BigInteger("36134250956749795798585127919587881956611106672985015071877198253568414405109");
        new ECPoint(bigInteger4, bigInteger5);
        new BigInteger("115792089210356248762697446949407573529996955224135760342422259061068512044369");
        new ECParameterSpec(ellipticCurve, eCPoint, bigInteger6, 1);
        P256 = eCParameterSpec;
        new BigInteger("39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112319");
        new ECFieldFp(bigInteger7);
        new BigInteger("39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112316");
        new BigInteger("27580193559959705877849011840389048093056905856361568521428707301988689241309860865136260764883745107765439761230575");
        new EllipticCurve(eCField2, bigInteger8, bigInteger9);
        new BigInteger("26247035095799689268623156744566981891852923491109213387815615900925518854738050089022388053975719786650872476732087");
        new BigInteger("8325710961489029985546751289520108179287853048861315594709205902480503199884419224438643760392947333078086511627871");
        new ECPoint(bigInteger10, bigInteger11);
        new BigInteger("39402006196394479212279040100143613805079739270465446667946905279627659399113263569398956308152294913554433653942643");
        new ECParameterSpec(ellipticCurve2, eCPoint2, bigInteger12, 1);
        P384 = eCParameterSpec2;
        new BigInteger("6864797660130609714981900799081393217269435300143305409394463459185543183397656052122559640661454554977296311391480858037121987999716643812574028291115057151");
        new ECFieldFp(bigInteger13);
        new BigInteger("6864797660130609714981900799081393217269435300143305409394463459185543183397656052122559640661454554977296311391480858037121987999716643812574028291115057148");
        new BigInteger("1093849038073734274511112390766805569936207598951683748994586394495953116150735016013708737573759623248592132296706313309438452531591012912142327488478985984");
        new EllipticCurve(eCField3, bigInteger14, bigInteger15);
        new BigInteger("2661740802050217063228768716723360960729859168756973147706671368418802944996427808491545080627771902352094241225065558662157113545570916814161637315895999846");
        new BigInteger("3757180025770020463545507224491183603594455134769762486694567779615544477440556316691234405012945539562144444537289428522585666729196580810124344277578376784");
        new ECPoint(bigInteger16, bigInteger17);
        new BigInteger("6864797660130609714981900799081393217269435300143305409394463459185543183397655394245057746333217197532963996371363321113864768612440380340372808892707005449");
        new ECParameterSpec(ellipticCurve3, eCPoint3, bigInteger18, 1);
        P521 = eCParameterSpec3;
        addCurve(P_256, P256);
        addCurve(P_384, P384);
        addCurve(P_521, P521);
    }

    private static void addCurve(String str, ECParameterSpec eCParameterSpec) {
        String name = str;
        ECParameterSpec spec = eCParameterSpec;
        ECParameterSpec put = nameToSpec.put(name, spec);
        String put2 = curveToName.put(spec.getCurve(), name);
    }

    public static ECParameterSpec getSpec(String name) {
        return nameToSpec.get(name);
    }

    public static String getName(EllipticCurve curve) {
        return curveToName.get(curve);
    }
}
