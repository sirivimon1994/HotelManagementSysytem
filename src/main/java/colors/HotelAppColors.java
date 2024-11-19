package colors;

import java.awt.Color;

public enum HotelAppColors {
    // Primary Colors
    DEEP_BLUE("#003366"),
    DARK_BLUE("#001d64"),  
    TEAL("#008080"),
    SLATE_GRAY("#708090"),
    DARK_BLUE2("#003083"), 
    
    // Secondary Colors
    TURQUOISE("#40E0D0"),
    CORAL("#FF7F50"),
    GOLDEN_ROD("#DAA520"),

    // Accent Colors
    CRIMSON("#DC143C"),
    DARK_SLATE_BLUE("#483D8B"),
    MEDIUM_ORCHID("#BA55D3"),
    SOFT_CORAL("#FF6F61"),
    PASTEL_BLUE("#B3CDE0"),

    // Background Colors
    LIGHT_GRAY("#F5F5F5"),
    WHITE_SMOKE("#F8F8FF"),

    // Text Colors
    CHARCOAL("#333333"),
    DIM_GRAY("#696969"),
 
    // Interactive Elements
    BRIGHT_CYAN("#00FFFF"),
    LIME_GREEN("#32CD32"),

    // Pastel Blue Colors
    PASTEL_BLUE_1("#B3CDE0"), // Light pastel blue
    PASTEL_BLUE_2("#A2B9BC"), // Soft blue-gray
    PASTEL_BLUE_3("#C6E2FF"), // Very light blue
    PASTEL_BLUE_4("#E0F7FA"), // Pale cyan-blue

    // Pastel Green Colors
    PASTEL_GREEN_1("#77DD77"), // Light pastel green
    PASTEL_GREEN_2("#B9FBC0"), // Soft green
    PASTEL_GREEN_3("#B2F2B1"), // Mint green
    PASTEL_GREEN_4("#C2F0C2"), // Pale green
    
    PALE_ROBIN_EGG_BLUE("#97cecc"),  // (151, 206, 204)
    BONDI_BLUE("#1aa6b7"),           // (26, 166, 183)
    TIFFANY_BLUE("#62c2cc"),         // (98, 194, 204)
    MEDIUM_TURQUOISE("#4cd0d0"),     // (76, 208, 208)
    TURQUOISE_BLUE("#3fe0d0"),       // (63, 224, 208)
    VIRDIAN_GREEN("#009797"),

	
    PRIMARY_RED("#E53935") ;
    
	
	
    private final Color color;

    HotelAppColors(String hex) {
        this.color = Color.decode(hex);
    }

    public Color getColor() {
        return color;
    }
}
