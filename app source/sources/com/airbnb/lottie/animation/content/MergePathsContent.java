package com.airbnb.lottie.animation.content;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
public class MergePathsContent implements PathContent, GreedyContent {
    private final Path firstPath;
    private final MergePaths mergePaths;
    private final String name;
    private final Path path;
    private final List<PathContent> pathContents;
    private final Path remainderPath;

    public MergePathsContent(MergePaths mergePaths2) {
        Path path2;
        Path path3;
        Path path4;
        List<PathContent> list;
        Throwable th;
        MergePaths mergePaths3 = mergePaths2;
        new Path();
        this.firstPath = path2;
        new Path();
        this.remainderPath = path3;
        new Path();
        this.path = path4;
        new ArrayList();
        this.pathContents = list;
        if (Build.VERSION.SDK_INT < 19) {
            Throwable th2 = th;
            new IllegalStateException("Merge paths are not supported pre-KitKat.");
            throw th2;
        }
        this.name = mergePaths3.getName();
        this.mergePaths = mergePaths3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x0002 A[LOOP:0: B:1:0x0002->B:4:0x000f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void absorbContent(java.util.ListIterator<com.airbnb.lottie.animation.content.Content> r6) {
        /*
            r5 = this;
            r0 = r5
            r1 = r6
        L_0x0002:
            r3 = r1
            boolean r3 = r3.hasPrevious()
            if (r3 == 0) goto L_0x0012
            r3 = r1
            java.lang.Object r3 = r3.previous()
            r4 = r0
            if (r3 == r4) goto L_0x0012
            goto L_0x0002
        L_0x0012:
            r3 = r1
            boolean r3 = r3.hasPrevious()
            if (r3 == 0) goto L_0x0035
            r3 = r1
            java.lang.Object r3 = r3.previous()
            com.airbnb.lottie.animation.content.Content r3 = (com.airbnb.lottie.animation.content.Content) r3
            r2 = r3
            r3 = r2
            boolean r3 = r3 instanceof com.airbnb.lottie.animation.content.PathContent
            if (r3 == 0) goto L_0x0034
            r3 = r0
            java.util.List<com.airbnb.lottie.animation.content.PathContent> r3 = r3.pathContents
            r4 = r2
            com.airbnb.lottie.animation.content.PathContent r4 = (com.airbnb.lottie.animation.content.PathContent) r4
            boolean r3 = r3.add(r4)
            r3 = r1
            r3.remove()
        L_0x0034:
            goto L_0x0012
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.MergePathsContent.absorbContent(java.util.ListIterator):void");
    }

    public void setContents(List<Content> list, List<Content> list2) {
        List<Content> contentsBefore = list;
        List<Content> contentsAfter = list2;
        for (int i = 0; i < this.pathContents.size(); i++) {
            this.pathContents.get(i).setContents(contentsBefore, contentsAfter);
        }
    }

    public Path getPath() {
        this.path.reset();
        if (this.mergePaths.isHidden()) {
            return this.path;
        }
        switch (this.mergePaths.getMode()) {
            case MERGE:
                addPaths();
                break;
            case ADD:
                opFirstPathWithRest(Path.Op.UNION);
                break;
            case SUBTRACT:
                opFirstPathWithRest(Path.Op.REVERSE_DIFFERENCE);
                break;
            case INTERSECT:
                opFirstPathWithRest(Path.Op.INTERSECT);
                break;
            case EXCLUDE_INTERSECTIONS:
                opFirstPathWithRest(Path.Op.XOR);
                break;
        }
        return this.path;
    }

    public String getName() {
        return this.name;
    }

    private void addPaths() {
        for (int i = 0; i < this.pathContents.size(); i++) {
            this.path.addPath(this.pathContents.get(i).getPath());
        }
    }

    @TargetApi(19)
    private void opFirstPathWithRest(Path.Op op) {
        Path.Op op2 = op;
        this.remainderPath.reset();
        this.firstPath.reset();
        for (int i = this.pathContents.size() - 1; i >= 1; i--) {
            PathContent content = this.pathContents.get(i);
            if (content instanceof ContentGroup) {
                List<PathContent> pathList = ((ContentGroup) content).getPathList();
                for (int j = pathList.size() - 1; j >= 0; j--) {
                    Path path2 = pathList.get(j).getPath();
                    path2.transform(((ContentGroup) content).getTransformationMatrix());
                    this.remainderPath.addPath(path2);
                }
            } else {
                this.remainderPath.addPath(content.getPath());
            }
        }
        PathContent lastContent = this.pathContents.get(0);
        if (lastContent instanceof ContentGroup) {
            List<PathContent> pathList2 = ((ContentGroup) lastContent).getPathList();
            for (int j2 = 0; j2 < pathList2.size(); j2++) {
                Path path3 = pathList2.get(j2).getPath();
                path3.transform(((ContentGroup) lastContent).getTransformationMatrix());
                this.firstPath.addPath(path3);
            }
        } else {
            this.firstPath.set(lastContent.getPath());
        }
        boolean op3 = this.path.op(this.firstPath, this.remainderPath, op2);
    }
}
