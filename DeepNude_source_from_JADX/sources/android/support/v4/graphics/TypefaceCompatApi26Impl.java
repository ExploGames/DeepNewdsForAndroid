package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    private static final String ABORT_CREATION_METHOD = "abortCreation";
    private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
    private static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String DEFAULT_FAMILY = "sans-serif";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String FREEZE_METHOD = "freeze";
    private static final int RESOLVE_BY_FONT_TABLE = -1;
    private static final String TAG = "TypefaceCompatApi26Impl";
    protected final Method mAbortCreation;
    protected final Method mAddFontFromAssetManager;
    protected final Method mAddFontFromBuffer;
    protected final Method mCreateFromFamiliesWithDefault;
    protected final Class mFontFamily;
    protected final Constructor mFontFamilyCtor;
    protected final Method mFreeze;

    public TypefaceCompatApi26Impl() {
        Constructor obtainFontFamilyCtor;
        Method obtainAddFontFromAssetManagerMethod;
        Method obtainAddFontFromBufferMethod;
        Method obtainFreezeMethod;
        Method obtainAbortCreationMethod;
        Method method;
        Throwable e;
        StringBuilder stringBuilder;
        Class cls = null;
        try {
            Class obtainFontFamily = obtainFontFamily();
            obtainFontFamilyCtor = obtainFontFamilyCtor(obtainFontFamily);
            obtainAddFontFromAssetManagerMethod = obtainAddFontFromAssetManagerMethod(obtainFontFamily);
            obtainAddFontFromBufferMethod = obtainAddFontFromBufferMethod(obtainFontFamily);
            obtainFreezeMethod = obtainFreezeMethod(obtainFontFamily);
            obtainAbortCreationMethod = obtainAbortCreationMethod(obtainFontFamily);
            cls = obtainCreateFromFamiliesWithDefaultMethod(obtainFontFamily);
            Class cls2 = obtainFontFamily;
            method = cls;
            cls = cls2;
        } catch (ClassNotFoundException e2) {
            e = e2;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to collect necessary methods for class ");
            stringBuilder.append(e.getClass().getName());
            Log.e(TAG, stringBuilder.toString(), e);
            method = cls;
            obtainFontFamilyCtor = method;
            obtainAddFontFromAssetManagerMethod = obtainFontFamilyCtor;
            obtainAddFontFromBufferMethod = obtainAddFontFromAssetManagerMethod;
            obtainFreezeMethod = obtainAddFontFromBufferMethod;
            obtainAbortCreationMethod = obtainFreezeMethod;
            this.mFontFamily = cls;
            this.mFontFamilyCtor = obtainFontFamilyCtor;
            this.mAddFontFromAssetManager = obtainAddFontFromAssetManagerMethod;
            this.mAddFontFromBuffer = obtainAddFontFromBufferMethod;
            this.mFreeze = obtainFreezeMethod;
            this.mAbortCreation = obtainAbortCreationMethod;
            this.mCreateFromFamiliesWithDefault = method;
        } catch (NoSuchMethodException e3) {
            e = e3;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to collect necessary methods for class ");
            stringBuilder.append(e.getClass().getName());
            Log.e(TAG, stringBuilder.toString(), e);
            method = cls;
            obtainFontFamilyCtor = method;
            obtainAddFontFromAssetManagerMethod = obtainFontFamilyCtor;
            obtainAddFontFromBufferMethod = obtainAddFontFromAssetManagerMethod;
            obtainFreezeMethod = obtainAddFontFromBufferMethod;
            obtainAbortCreationMethod = obtainFreezeMethod;
            this.mFontFamily = cls;
            this.mFontFamilyCtor = obtainFontFamilyCtor;
            this.mAddFontFromAssetManager = obtainAddFontFromAssetManagerMethod;
            this.mAddFontFromBuffer = obtainAddFontFromBufferMethod;
            this.mFreeze = obtainFreezeMethod;
            this.mAbortCreation = obtainAbortCreationMethod;
            this.mCreateFromFamiliesWithDefault = method;
        }
        this.mFontFamily = cls;
        this.mFontFamilyCtor = obtainFontFamilyCtor;
        this.mAddFontFromAssetManager = obtainAddFontFromAssetManagerMethod;
        this.mAddFontFromBuffer = obtainAddFontFromBufferMethod;
        this.mFreeze = obtainFreezeMethod;
        this.mAbortCreation = obtainAbortCreationMethod;
        this.mCreateFromFamiliesWithDefault = method;
    }

    private void abortCreation(Object obj) {
        Throwable e;
        try {
            this.mAbortCreation.invoke(obj, new Object[0]);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    private boolean addFontFromAssetManager(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        Throwable e;
        try {
            return ((Boolean) this.mAddFontFromAssetManager.invoke(obj, new Object[]{context.getAssets(), str, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr})).booleanValue();
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    private boolean addFontFromBuffer(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        Throwable e;
        try {
            return ((Boolean) this.mAddFontFromBuffer.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    private boolean freeze(Object obj) {
        Throwable e;
        try {
            return ((Boolean) this.mFreeze.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    private boolean isFontFamilyPrivateAPIAvailable() {
        if (this.mAddFontFromAssetManager == null) {
            Log.w(TAG, "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.mAddFontFromAssetManager != null;
    }

    private Object newFamily() {
        Throwable e;
        try {
            return this.mFontFamilyCtor.newInstance(new Object[0]);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InstantiationException e3) {
            e = e3;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e4) {
            e = e4;
            throw new RuntimeException(e);
        }
    }

    protected Typeface createFromFamiliesWithDefault(Object obj) {
        Throwable e;
        try {
            Array.set(Array.newInstance(this.mFontFamily, 1), 0, obj);
            return (Typeface) this.mCreateFromFamiliesWithDefault.invoke(null, new Object[]{r0, Integer.valueOf(-1), Integer.valueOf(-1)});
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new RuntimeException(e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromFontFamilyFilesResourceEntry(context, fontFamilyFilesResourceEntry, resources, i);
        }
        Object newFamily = newFamily();
        FontFileResourceEntry[] entries = fontFamilyFilesResourceEntry.getEntries();
        i = entries.length;
        int i2 = 0;
        while (i2 < i) {
            FontFileResourceEntry fontFileResourceEntry = entries[i2];
            if (addFontFromAssetManager(context, newFamily, fontFileResourceEntry.getFileName(), fontFileResourceEntry.getTtcIndex(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic(), FontVariationAxis.fromFontVariationSettings(fontFileResourceEntry.getVariationSettings()))) {
                i2++;
            } else {
                abortCreation(newFamily);
                return null;
            }
        }
        return !freeze(newFamily) ? null : createFromFamiliesWithDefault(newFamily);
    }

    public android.graphics.Typeface createFromFontInfo(android.content.Context r12, android.os.CancellationSignal r13, android.support.v4.provider.FontsContractCompat.FontInfo[] r14, int r15) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/318857719.run(Unknown Source)
*/
        /*
        r11 = this;
        r0 = r14.length;
        r1 = 1;
        r2 = 0;
        if (r0 >= r1) goto L_0x0006;
    L_0x0005:
        return r2;
    L_0x0006:
        r0 = r11.isFontFamilyPrivateAPIAvailable();
        if (r0 != 0) goto L_0x0064;
    L_0x000c:
        r14 = r11.findBestInfo(r14, r15);
        r12 = r12.getContentResolver();
        r15 = r14.getUri();	 Catch:{ IOException -> 0x0063 }
        r0 = "r";	 Catch:{ IOException -> 0x0063 }
        r12 = r12.openFileDescriptor(r15, r0, r13);	 Catch:{ IOException -> 0x0063 }
        if (r12 != 0) goto L_0x0026;	 Catch:{ IOException -> 0x0063 }
    L_0x0020:
        if (r12 == 0) goto L_0x0025;	 Catch:{ IOException -> 0x0063 }
    L_0x0022:
        r12.close();	 Catch:{ IOException -> 0x0063 }
    L_0x0025:
        return r2;
    L_0x0026:
        r13 = new android.graphics.Typeface$Builder;	 Catch:{ Throwable -> 0x004c, all -> 0x0049 }
        r15 = r12.getFileDescriptor();	 Catch:{ Throwable -> 0x004c, all -> 0x0049 }
        r13.<init>(r15);	 Catch:{ Throwable -> 0x004c, all -> 0x0049 }
        r15 = r14.getWeight();	 Catch:{ Throwable -> 0x004c, all -> 0x0049 }
        r13 = r13.setWeight(r15);	 Catch:{ Throwable -> 0x004c, all -> 0x0049 }
        r14 = r14.isItalic();	 Catch:{ Throwable -> 0x004c, all -> 0x0049 }
        r13 = r13.setItalic(r14);	 Catch:{ Throwable -> 0x004c, all -> 0x0049 }
        r13 = r13.build();	 Catch:{ Throwable -> 0x004c, all -> 0x0049 }
        if (r12 == 0) goto L_0x0048;
    L_0x0045:
        r12.close();	 Catch:{ IOException -> 0x0063 }
    L_0x0048:
        return r13;
    L_0x0049:
        r13 = move-exception;
        r14 = r2;
        goto L_0x0052;
    L_0x004c:
        r13 = move-exception;
        throw r13;	 Catch:{ all -> 0x004e }
    L_0x004e:
        r14 = move-exception;
        r10 = r14;
        r14 = r13;
        r13 = r10;
    L_0x0052:
        if (r12 == 0) goto L_0x0062;
    L_0x0054:
        if (r14 == 0) goto L_0x005f;
    L_0x0056:
        r12.close();	 Catch:{ Throwable -> 0x005a }
        goto L_0x0062;
    L_0x005a:
        r12 = move-exception;
        r14.addSuppressed(r12);	 Catch:{ IOException -> 0x0063 }
        goto L_0x0062;	 Catch:{ IOException -> 0x0063 }
    L_0x005f:
        r12.close();	 Catch:{ IOException -> 0x0063 }
    L_0x0062:
        throw r13;	 Catch:{ IOException -> 0x0063 }
    L_0x0063:
        return r2;
    L_0x0064:
        r12 = android.support.v4.provider.FontsContractCompat.prepareFontData(r12, r14, r13);
        r13 = r11.newFamily();
        r0 = r14.length;
        r3 = 0;
        r9 = 0;
    L_0x006f:
        if (r9 >= r0) goto L_0x009c;
    L_0x0071:
        r4 = r14[r9];
        r5 = r4.getUri();
        r5 = r12.get(r5);
        r5 = (java.nio.ByteBuffer) r5;
        if (r5 != 0) goto L_0x0080;
    L_0x007f:
        goto L_0x0099;
    L_0x0080:
        r6 = r4.getTtcIndex();
        r7 = r4.getWeight();
        r8 = r4.isItalic();
        r3 = r11;
        r4 = r13;
        r3 = r3.addFontFromBuffer(r4, r5, r6, r7, r8);
        if (r3 != 0) goto L_0x0098;
    L_0x0094:
        r11.abortCreation(r13);
        return r2;
    L_0x0098:
        r3 = 1;
    L_0x0099:
        r9 = r9 + 1;
        goto L_0x006f;
    L_0x009c:
        if (r3 != 0) goto L_0x00a2;
    L_0x009e:
        r11.abortCreation(r13);
        return r2;
    L_0x00a2:
        r12 = r11.freeze(r13);
        if (r12 != 0) goto L_0x00a9;
    L_0x00a8:
        return r2;
    L_0x00a9:
        r12 = r11.createFromFamiliesWithDefault(r13);
        r12 = android.graphics.Typeface.create(r12, r15);
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi26Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, android.support.v4.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }

    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromResourcesFontFile(context, resources, i, str, i2);
        }
        Object newFamily = newFamily();
        if (addFontFromAssetManager(context, newFamily, str, 0, -1, -1, null)) {
            return !freeze(newFamily) ? null : createFromFamiliesWithDefault(newFamily);
        } else {
            abortCreation(newFamily);
            return null;
        }
    }

    protected Method obtainAbortCreationMethod(Class cls) {
        return cls.getMethod(ABORT_CREATION_METHOD, new Class[0]);
    }

    protected Method obtainAddFontFromAssetManagerMethod(Class cls) {
        r0 = new Class[8];
        Class cls2 = Integer.TYPE;
        r0[4] = cls2;
        r0[5] = cls2;
        r0[6] = cls2;
        r0[7] = FontVariationAxis[].class;
        return cls.getMethod(ADD_FONT_FROM_ASSET_MANAGER_METHOD, r0);
    }

    protected Method obtainAddFontFromBufferMethod(Class cls) {
        r0 = new Class[5];
        Class cls2 = Integer.TYPE;
        r0[1] = cls2;
        r0[2] = FontVariationAxis[].class;
        r0[3] = cls2;
        r0[4] = cls2;
        return cls.getMethod(ADD_FONT_FROM_BUFFER_METHOD, r0);
    }

    protected Method obtainCreateFromFamiliesWithDefaultMethod(Class cls) {
        r2 = new Class[3];
        cls = Integer.TYPE;
        r2[1] = cls;
        r2[2] = cls;
        Method declaredMethod = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, r2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    protected Class obtainFontFamily() {
        return Class.forName(FONT_FAMILY_CLASS);
    }

    protected Constructor obtainFontFamilyCtor(Class cls) {
        return cls.getConstructor(new Class[0]);
    }

    protected Method obtainFreezeMethod(Class cls) {
        return cls.getMethod(FREEZE_METHOD, new Class[0]);
    }
}
