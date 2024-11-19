package utils;

import java.awt.Font;

public class FontConfig {
 
    public static final Font BODY_FONT = new Font("SansSerif", Font.PLAIN, 12);
    
    public static final Font TITLE_FONT = new Font("SansSerif", Font.BOLD, 24); 
    public static final Font HEADER_FONT = new Font("SansSerif", Font.BOLD, 18); 
    public static final Font SUBHEADER_FONT = new Font("SansSerif", Font.BOLD, 14); 
    public static final Font BUTTON_FONT = new Font("SansSerif", Font.PLAIN, 12); 
    public static final Font MENU_FONT = new Font("SansSerif", Font.PLAIN, 14); 
    public static final Font TOOLTIP_FONT = new Font("SansSerif", Font.PLAIN, 11); 
    public static final Font HEADER_FONT_PLAIN = new Font("SansSerif", Font.PLAIN, 18); 

    public static Font getTitleFont() {
        return TITLE_FONT;
    }

    public static Font getHeaderFont() {
        return HEADER_FONT;
    }

    public static Font getSubheaderFont() {
        return SUBHEADER_FONT;
    }

    public static Font getBodyFont() {
        return BODY_FONT;
    }

    public static Font getButtonFont() {
        return BUTTON_FONT;
    }

    public static Font getMenuFont() {
        return MENU_FONT;
    }

    public static Font getTooltipFont() {
        return TOOLTIP_FONT;
    }
    
    public static Font getHeaderPlainFont() {
        return HEADER_FONT_PLAIN;
    }
	    
}
