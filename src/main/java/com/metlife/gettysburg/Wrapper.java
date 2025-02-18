package com.metlife.gettysburg;

public class Wrapper {

    public String wrap(String text, int width) {
        if (text.length() <= width) {
            return text;
        } else {
            int br = text.lastIndexOf(" ", width);
            if (br == -1) {
                br = width;
            }
            return text.substring(0, br).trim() + "\n" + wrap(text.substring(br).trim(), width);
        }
    }
}
