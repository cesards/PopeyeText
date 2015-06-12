package com.cesards.android.popeyetext.exception;

/**
 * Created by cesards on 12/06/15.
 */
public class TextComposerException extends RuntimeException {

    public TextComposerException() { }

    public TextComposerException(String detailMessage) {
        super(detailMessage);
    }

    public TextComposerException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public TextComposerException(Throwable throwable) {
        super(throwable);
    }
}
