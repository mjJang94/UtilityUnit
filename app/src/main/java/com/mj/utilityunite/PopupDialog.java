package com.mj.utilityunite;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.TextView;



/**
 * 커스텀 팝업 DIALOG
 */
public class PopupDialog extends Dialog {

    private static final String TAG = PopupDialog.class.getSimpleName();

    public PopupDialog(Context context) {
        super(context);
    }

    private PopupDialog(Context context, int theme) {
        super(context, theme);
    }

    public static PopupDialog show(Context context, int title, int message) {

        if (context instanceof Activity
                && !((Activity) context).isFinishing()) {
            Builder builder = new Builder(context);
            builder.setTitle(title);
            builder.setMessage(message);
            PopupDialog dialog = builder.create();
            dialog.show();
            return dialog;
        }

        return null;

    }

    public static PopupDialog show(Context context, String title, String message) {
        Builder builder = new Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        PopupDialog dialog = builder.create();
        try {
            dialog.show();
        } catch (WindowManager.BadTokenException e) {
            Log.d(TAG, "show(Context context, String title, String message) " + e.getMessage());
        }

        return dialog;
    }



    public static PopupDialog show(Context context, int title, int message, OnClickListener confirmListener) {
        Builder builder = new Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButtonClick(confirmListener);
        PopupDialog dialog = builder.create();

        if (context instanceof Activity
                && !((Activity) context).isFinishing()) {
            dialog.show();
        }
        return dialog;
    }

    public static PopupDialog show(Context context, String title, String message, OnClickListener confirmListener) {
        Builder builder = new Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButtonClick(confirmListener);
        PopupDialog dialog = builder.create();

        if (context instanceof Activity
                && !((Activity) context).isFinishing()) {
            dialog.show();
        }
        return dialog;
    }

    public static PopupDialog show(Context context, int title, int message, int positiveButtonText, OnClickListener confirmListener) {
        Builder builder = new Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButtonText(positiveButtonText);
        builder.setPositiveButtonClick(confirmListener);
        PopupDialog dialog = builder.create();

        if (context instanceof Activity
                && !((Activity) context).isFinishing()) {
            dialog.show();
        }
        return dialog;
    }

    public static PopupDialog show(Context context, int title, int message, OnClickListener confirmListener, OnClickListener cancelListner) {
        Builder builder = new Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButtonClick(confirmListener);
        builder.setNegativeButtonClick(cancelListner);
        PopupDialog dialog = builder.create();

        if (context instanceof Activity
                && !((Activity) context).isFinishing()) {
            dialog.show();
        }

        return dialog;
    }

    public static PopupDialog show(Context context, String title, String message, OnClickListener confirmListener, OnClickListener cancelListner) {
        Builder builder = new Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButtonClick(confirmListener);
        builder.setNegativeButtonClick(cancelListner);
        PopupDialog dialog = builder.create();

        if (context instanceof Activity
                && !((Activity) context).isFinishing()) {
            dialog.show();
        }

        return dialog;
    }

    /**
     * context, String, String, String, DialogInterface.OnClickListener
     **/
    public static PopupDialog show(Context context, String title, String message, String positiveButtonText, OnClickListener confirmListener) {
        Builder builder = new Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButtonText(positiveButtonText);
        builder.setPositiveButtonClick(confirmListener);
        PopupDialog dialog = builder.create();

        if (context instanceof Activity
                && !((Activity) context).isFinishing()) {
            dialog.show();
        }


        return dialog;
    }

    /**
     * context, int, int, int, DialogInterface.OnClickListener, int, DialogInterface.OnClickListener
     **/
    public static PopupDialog show(Context context, int title, int message, int negativeButtonText, OnClickListener cancelListener, int positiveButtonText, OnClickListener confirmListener) {
        Builder builder = new Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButtonText(positiveButtonText);
        builder.setPositiveButtonClick(confirmListener);
        builder.setNegativeButtonText(negativeButtonText);
        builder.setNegativeButtonClick(cancelListener);
        PopupDialog dialog = builder.create();

        if (context instanceof Activity
                && !((Activity) context).isFinishing()) {
            dialog.show();
        }

        return dialog;
    }

    /**
     * context, String, String, int, DialogInterface.OnClickListener, int, DialogInterface.OnClickListener
     **/
    public static PopupDialog show(Context context, String title, String message, int negativeButtonText, OnClickListener cancelListener, int positiveButtonText, OnClickListener confirmListener) {
        Builder builder = new Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButtonText(positiveButtonText);
        builder.setPositiveButtonClick(confirmListener);
        builder.setNegativeButtonText(negativeButtonText);
        builder.setNegativeButtonClick(cancelListener);
        PopupDialog dialog = builder.create();

        if (context instanceof Activity
                && !((Activity) context).isFinishing()) {
            dialog.show();
        }

        return dialog;
    }

    /**
     * context, String, String, String, DialogInterface.OnClickListener, String, DialogInterface.OnClickListener
     **/
    public static PopupDialog showOusideTouch(Context context, String title, String message, String negativeButtonText, OnClickListener cancelListener, String positiveButtonText, OnClickListener confirmListener) {
        Builder builder = new Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setNegativeButtonText(negativeButtonText);
        builder.setNegativeButtonClick(cancelListener);
        builder.setPositiveButtonText(positiveButtonText);
        builder.setPositiveButtonClick(confirmListener);
        PopupDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);

        if (context instanceof Activity
                && !((Activity) context).isFinishing()) {
            dialog.show();
        }

        return dialog;
    }

    /**
     * Builder CLASS
     */
    public static class Builder {
        Context context;
        String title;
        String message;
        String positiveButtonText;
        String negativeButtonText;
        View contentView;
        OnClickListener positiveButtonClickListener;
        OnClickListener negativeButtonClickListener;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTitle(int title) {
            this.title = (String) context.getText(title);
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setMessage(int message) {
            this.message = (String) context.getText(message);
            return this;
        }

        public Builder setPositiveButtonText(int positiveButtonText) {
            this.positiveButtonText = (String) context.getText(positiveButtonText);
            return this;
        }

        public Builder setPositiveButtonText(String positiveButtonText) {
            this.positiveButtonText = positiveButtonText;
            return this;
        }

        public Builder setNegativeButtonText(int positiveButtonText) {
            this.negativeButtonText = (String) context.getText(positiveButtonText);
            return this;
        }

        public Builder setNegativeButtonText(String negativeButtonText) {
            this.negativeButtonText = negativeButtonText;
            return this;
        }

        public Builder setPositiveButtonClick(OnClickListener listener) {
            this.positiveButtonClickListener = listener;
            return this;
        }

        public Builder setNegativeButtonClick(OnClickListener listener) {
            this.negativeButtonClickListener = listener;
            return this;
        }

        public PopupDialog create() {
            return create(0);
        }

        public PopupDialog create(int dialogLayout) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final PopupDialog dialog = new PopupDialog(context, R.style.DialogProgress);
            if (dialogLayout != 0)
                contentView = inflater.inflate(dialogLayout, null);
            else
                contentView = inflater.inflate(R.layout.dialog_common, null);

            dialog.addContentView(contentView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

            //타이틀
            TextView tvTitle = (TextView) contentView.findViewById(R.id.tv_title_dialog);
            tvTitle.setText(title);


            //메시지
            TextView tvMsg = (TextView) contentView.findViewById(R.id.tv_msg_dialog);
            tvMsg.setText(message);

            //확인 버튼
            TextView tvPositive = (TextView) contentView.findViewById(R.id.bt_positive);
            if (positiveButtonText != null && !"".equals(positiveButtonText)) {
                tvPositive.setText(positiveButtonText);
            }
            tvPositive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    if (positiveButtonClickListener != null) {
                        positiveButtonClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                    }
                }
            });

            //취소 버튼
            TextView tvNegative = (TextView) contentView.findViewById(R.id.bt_negative);
            if (negativeButtonText != null && !"".equals(negativeButtonText)) {
                tvNegative.setText(negativeButtonText);
            }
            if (negativeButtonClickListener != null) {
                tvNegative.setVisibility(View.VISIBLE);
            }
            tvNegative.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    if (negativeButtonClickListener != null) {
                        negativeButtonClickListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
                    }
                }
            });

            dialog.setContentView(contentView);
			dialog.setCancelable(false);
//			dialog.setCanceledOnTouchOutside(false);
            return dialog;
        }
    }
}