package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.appcompat.C0222R;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AppCompatImageHelper {
    private TintInfo mImageTint;
    private TintInfo mInternalImageTint;
    private TintInfo mTmpInfo;
    private final ImageView mView;

    public AppCompatImageHelper(ImageView imageView) {
        this.mView = imageView;
    }

    private boolean applyFrameworkTintUsingColorFilter(Drawable drawable) {
        if (this.mTmpInfo == null) {
            this.mTmpInfo = new TintInfo();
        }
        TintInfo tintInfo = this.mTmpInfo;
        tintInfo.clear();
        ColorStateList imageTintList = ImageViewCompat.getImageTintList(this.mView);
        if (imageTintList != null) {
            tintInfo.mHasTintList = true;
            tintInfo.mTintList = imageTintList;
        }
        Mode imageTintMode = ImageViewCompat.getImageTintMode(this.mView);
        if (imageTintMode != null) {
            tintInfo.mHasTintMode = true;
            tintInfo.mTintMode = imageTintMode;
        }
        if (!tintInfo.mHasTintList) {
            if (!tintInfo.mHasTintMode) {
                return false;
            }
        }
        AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
        return true;
    }

    private boolean shouldApplyFrameworkTintUsingColorFilter() {
        int i = VERSION.SDK_INT;
        boolean z = true;
        if (i <= 21) {
            return i == 21;
        } else {
            if (this.mInternalImageTint == null) {
                z = false;
            }
            return z;
        }
    }

    void applySupportImageTint() {
        Drawable drawable = this.mView.getDrawable();
        if (drawable != null) {
            DrawableUtils.fixDrawable(drawable);
        }
        if (drawable != null && (!shouldApplyFrameworkTintUsingColorFilter() || !applyFrameworkTintUsingColorFilter(drawable))) {
            TintInfo tintInfo = this.mImageTint;
            if (tintInfo != null) {
                AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
            } else {
                tintInfo = this.mInternalImageTint;
                if (tintInfo != null) {
                    AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
                }
            }
        }
    }

    ColorStateList getSupportImageTintList() {
        TintInfo tintInfo = this.mImageTint;
        return tintInfo != null ? tintInfo.mTintList : null;
    }

    Mode getSupportImageTintMode() {
        TintInfo tintInfo = this.mImageTint;
        return tintInfo != null ? tintInfo.mTintMode : null;
    }

    boolean hasOverlappingRendering() {
        return VERSION.SDK_INT < 21 || !(this.mView.getBackground() instanceof RippleDrawable);
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, C0222R.styleable.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.mView.getDrawable();
            if (drawable == null) {
                int resourceId = obtainStyledAttributes.getResourceId(C0222R.styleable.AppCompatImageView_srcCompat, -1);
                if (resourceId != -1) {
                    drawable = AppCompatResources.getDrawable(this.mView.getContext(), resourceId);
                    if (drawable != null) {
                        this.mView.setImageDrawable(drawable);
                    }
                }
            }
            if (drawable != null) {
                DrawableUtils.fixDrawable(drawable);
            }
            if (obtainStyledAttributes.hasValue(C0222R.styleable.AppCompatImageView_tint)) {
                ImageViewCompat.setImageTintList(this.mView, obtainStyledAttributes.getColorStateList(C0222R.styleable.AppCompatImageView_tint));
            }
            if (obtainStyledAttributes.hasValue(C0222R.styleable.AppCompatImageView_tintMode)) {
                ImageViewCompat.setImageTintMode(this.mView, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(C0222R.styleable.AppCompatImageView_tintMode, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    public void setImageResource(int i) {
        if (i != 0) {
            Drawable drawable = AppCompatResources.getDrawable(this.mView.getContext(), i);
            if (drawable != null) {
                DrawableUtils.fixDrawable(drawable);
            }
            this.mView.setImageDrawable(drawable);
        } else {
            this.mView.setImageDrawable(null);
        }
        applySupportImageTint();
    }

    void setInternalImageTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.mInternalImageTint == null) {
                this.mInternalImageTint = new TintInfo();
            }
            TintInfo tintInfo = this.mInternalImageTint;
            tintInfo.mTintList = colorStateList;
            tintInfo.mHasTintList = true;
        } else {
            this.mInternalImageTint = null;
        }
        applySupportImageTint();
    }

    void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.mImageTint == null) {
            this.mImageTint = new TintInfo();
        }
        TintInfo tintInfo = this.mImageTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = true;
        applySupportImageTint();
    }

    void setSupportImageTintMode(Mode mode) {
        if (this.mImageTint == null) {
            this.mImageTint = new TintInfo();
        }
        TintInfo tintInfo = this.mImageTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = true;
        applySupportImageTint();
    }
}
