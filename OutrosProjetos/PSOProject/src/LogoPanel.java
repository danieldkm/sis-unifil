
import java.awt.*;
import javax.swing.*;

/*--------------------------------------------------------------------*/
class LogoPanel extends JPanel {
/*--------------------------------------------------------------------*/

  private static final long serialVersionUID = 1L;

  private byte[] logodata = {   /* data for logo (GIF format) */
      71,  73,  70,  56,  57,  97, 100,   0, 101,   0, -25,   0,
       0,   0,   0,   0,   1,   1,   1,   2,   2,   2,   3,   3,
       3,   4,   4,   4,   5,   5,   5,   6,   6,   6,   7,   7,
       7,   8,   8,   8,   9,   9,   9,  10,  10,  10,  11,  11,
      11,  12,  12,  12,  13,  13,  13,  14,  14,  14,  15,  15,
      15,  16,  16,  16,  17,  17,  17,  18,  18,  18,  19,  19,
      19,  20,  20,  20,  21,  21,  21,  22,  22,  22,  23,  23,
      23,  24,  24,  24,  25,  25,  25,  26,  26,  26,  27,  27,
      27,  28,  28,  28,  29,  29,  29,  30,  30,  30,  31,  31,
      31,  32,  32,  32,  33,  33,  33,  34,  34,  34,  35,  35,
      35,  36,  36,  36,  37,  37,  37,  38,  38,  38,  39,  39,
      39,  40,  40,  40,  41,  41,  41,  42,  42,  42,  43,  43,
      43,  44,  44,  44,  45,  45,  45,  46,  46,  46,  47,  47,
      47,  48,  48,  48,  49,  49,  49,  50,  50,  50,  51,  51,
      51,  52,  52,  52,  53,  53,  53,  54,  54,  54,  55,  55,
      55,  56,  56,  56,  57,  57,  57,  58,  58,  58,  59,  59,
      59,  60,  60,  60,  61,  61,  61,  62,  62,  62,  63,  63,
      63,  64,  64,  64,  65,  65,  65,  66,  66,  66,  67,  67,
      67,  68,  68,  68,  69,  69,  69,  70,  70,  70,  71,  71,
      71,  72,  72,  72,  73,  73,  73,  74,  74,  74,  75,  75,
      75,  76,  76,  76,  77,  77,  77,  78,  78,  78,  79,  79,
      79,  80,  80,  80,  81,  81,  81,  82,  82,  82,  83,  83,
      83,  84,  84,  84,  85,  85,  85,  86,  86,  86,  87,  87,
      87,  88,  88,  88,  89,  89,  89,  90,  90,  90,  91,  91,
      91,  92,  92,  92,  93,  93,  93,  94,  94,  94,  95,  95,
      95,  96,  96,  96,  97,  97,  97,  98,  98,  98,  99,  99,
      99, 100, 100, 100, 101, 101, 101, 102, 102, 102, 103, 103,
     103, 104, 104, 104, 105, 105, 105, 106, 106, 106, 107, 107,
     107, 108, 108, 108, 109, 109, 109, 110, 110, 110, 111, 111,
     111, 112, 112, 112, 113, 113, 113, 114, 114, 114, 115, 115,
     115, 116, 116, 116, 117, 117, 117, 118, 118, 118, 119, 119,
     119, 120, 120, 120, 121, 121, 121, 122, 122, 122, 123, 123,
     123, 124, 124, 124, 125, 125, 125, 126, 126, 126, 127, 127,
     127,-128,-128,-128,-127,-127,-127,-126,-126,-126,-125,-125,
    -125,-124,-124,-124,-123,-123,-123,-122,-122,-122,-121,-121,
    -121,-120,-120,-120,-119,-119,-119,-118,-118,-118,-117,-117,
    -117,-116,-116,-116,-115,-115,-115,-114,-114,-114,-113,-113,
    -113,-112,-112,-112,-111,-111,-111,-110,-110,-110,-109,-109,
    -109,-108,-108,-108,-107,-107,-107,-106,-106,-106,-105,-105,
    -105,-104,-104,-104,-103,-103,-103,-102,-102,-102,-101,-101,
    -101,-100,-100,-100, -99, -99, -99, -98, -98, -98, -97, -97,
     -97, -96, -96, -96, -95, -95, -95, -94, -94, -94, -93, -93,
     -93, -92, -92, -92, -91, -91, -91, -90, -90, -90, -89, -89,
     -89, -88, -88, -88, -87, -87, -87, -86, -86, -86, -85, -85,
     -85, -84, -84, -84, -83, -83, -83, -82, -82, -82, -81, -81,
     -81, -80, -80, -80, -79, -79, -79, -78, -78, -78, -77, -77,
     -77, -76, -76, -76, -75, -75, -75, -74, -74, -74, -73, -73,
     -73, -72, -72, -72, -71, -71, -71, -70, -70, -70, -69, -69,
     -69, -68, -68, -68, -67, -67, -67, -66, -66, -66, -65, -65,
     -65, -64, -64, -64, -63, -63, -63, -62, -62, -62, -61, -61,
     -61, -60, -60, -60, -59, -59, -59, -58, -58, -58, -57, -57,
     -57, -56, -56, -56, -55, -55, -55, -54, -54, -54, -53, -53,
     -53, -52, -52, -52, -51, -51, -51, -50, -50, -50, -49, -49,
     -49, -48, -48, -48, -47, -47, -47, -46, -46, -46, -45, -45,
     -45, -44, -44, -44, -43, -43, -43, -42, -42, -42, -41, -41,
     -41, -40, -40, -40, -39, -39, -39, -38, -38, -38, -37, -37,
     -37, -36, -36, -36, -35, -35, -35, -34, -34, -34, -33, -33,
     -33, -32, -32, -32, -31, -31, -31, -30, -30, -30, -29, -29,
     -29, -28, -28, -28, -27, -27, -27, -26, -26, -26, -25, -25,
     -25, -24, -24, -24, -23, -23, -23, -22, -22, -22, -21, -21,
     -21, -20, -20, -20, -19, -19, -19, -18, -18, -18, -17, -17,
     -17, -16, -16, -16, -15, -15, -15, -14, -14, -14, -13, -13,
     -13, -12, -12, -12, -11, -11, -11, -10, -10, -10,  -9,  -9,
      -9,  -8,  -8,  -8,  -7,  -7,  -7,  -6,  -6,  -6,  -5,  -5,
      -5,  -4,  -4,  -4,  -3,  -3,  -3,  -2,  -2,  -2,  -1,  -1,
      -1,  33,  -7,   4,   1,  10,   0,  -1,   0,  44,   0,   0,
       0,   0, 100,   0, 101,   0,   0,   8,  -2,   0,  -1,   9,
      28,  72, -80, -96, -63,-125,   8,  15,   2,  88, -56, -80,
      33, -61,-124,  16,  35,  74,-100,  72,-111,  98, -61,-119,
      14,  43, 106, -36, -56,  49, -31, -61,-114,   2,  51,-126,
      28,  73, 114, -32,  71,-123,  33,  77, -86,  68, -72, -80,
     -92,  75,-115,  45,  81, -90,  -4,  23,  19, -64,  74,-101,
      10,  99, -66, -36,  73,  80,  39, -53,-101,  56, 113, -46,
    -100,  41, -76, -96,  79, -98,  36,-113,  30,  29,  74, 116,
     104, -48,-101,  33,-117,  70,  69,-102, -44, -96, -44, -89,
      77, 105,  98, 117, -86,  82, -22,  84, -86,  48,-123,-118,
     -43, 106,  85, -25,  88, -90, 100, -65, -86, -99,   9,  54,
     -94, -46, -98,  47,-117, -38,  28, 123, -43, 107, -37,-107,
      89,  83,  46,   5, -23, 115,  43, -36, -69,  70, -83, 106,
      61,-117,  84, -20,  73, -71,-128, -43,-102, -11, 123, 119,
     -21, -36, -65, 109,  17,   7,  78,  44,-109, 107,  79, -69,
      37, -81,  10, -90,  44,  -8,  49,  94, -76, 113,  55,-125,
     -26,-116, -46, -16, 100,-105,-110,-103,  98,  38,-115,-105,
     -16, -24,-114, 117,  77, -82,  14, 123,-111, -17, -23, -39,
      24, 127, -14, 117, -56,  91,  36,  76, -93, -82,  57,-102,
      -2, 108, -79, -73, 113, -34, -74, -47, -30, -10,   8,-107,
      45, -58, -29, -48, 125,  87, -60, -68,  92, -76, 106, -31,
     -47, -77,  35, -49, -67, -71,  58, 113, -78, 123,  89,  -2,
      70,  31, -84,  -3, -28, 116, -84, -34,-107, 127, 119,-101,
      61,  42, 114, -24, -65,  65, 123,  63, -53,  24, -94, 118,
     -32,  25,-113,  79, -73, -68,  94, -76, 103, -38, -58,  61,
      55,  87,-128,  97, -27, -59, -36,  95, -23,-111,  87,  91,
     124,   4, -18, -57, -42, 108, 118,  -3,  39,-111, 126,  27,
     -43, -44,-101,-125, -51, -23,  38,  31,-128, -46, -99,  39,
     -37,-126,  21,   6,   7,  89,  90,  33,  54, -72,  27,-120,
     -59,  25,  56,  98, 127,  30, -63,-105, -44, 118,  22,  65,
      22, -95, 115,   9,  42,-120, -30,-119,  29, -62, -26, -97,
    -120, -10,  81,  -8, -30,-123,-103,  89,  55,  88,-119,  64,
      -2,   8,  99,  85,  43, -98, 104,  35, 106,  62,-114,-108,
      90, 125, -20,  61,-108,  35, 108,  77, -98,  71,  24, 122,
     -81,-119,-105, -97, 121,  70,  30,  -7, -36,-125, -51,  73,
     -88, -27,-106,  38,  18, -23,  37,-122, -22, 109, -24, -42,
    -112, -18,  85, 121,  89,  75,  74, -71,  -7, -91,-127,  80,
      86,  86, -34, 106,  -7, -31,  87, 100,-120,  93,   1,  87,
     -36, 120, 111,  34,  88,-103,-115,  83, -74, -88,  89,-115,
     119,  14, 104, -95,  92, 120, -66,  89, -90, 112,  89, -10,
    -104, -24,  71,  92, -74,  73, -36, 125, -69,  97,-105,  40,
    -101,  17,-118,  89,  87, 123,-110,  50, 106, 102, 121,  75,
    -106, 117, -29,-121,-128, -82, 105,  33, -86, 120, -34, -23,
     -36, -85,  -2, 105,  77,  73, -22,-124, -79, 122,   5, -95,
     -85, -18, -11,  55,  96, -92, -77,  26,  42, 106,-110, -90,
    -126,  90, -42,-124, -99,  98, -54,  39,-117,-114, -70,-104,
    -109,-109, -67,  22, -40,  38, 110, -97, -98, -70, -42, -88,
     -54,-114,  41,  91,  92, 103,   2,  -5, -89, -79,-125,   6,
      85,  99,  78, -39, -62, -54,  33, -73,  35, 122, -21, -24,
     -74, -31,  70, 106,  37, -82,-127, -95, -25,  90, 117, -87,
      94,  38, 100,-108, -20,  -6,  57,-100,-102, -95, -54, 105,
     -21, -72, -62, -46, -22, -41, 114, -28, 126,   5,  39, -75,
     -43, -86,-118,  42, -70, 123, -54,  -5,  45, -95,   5, -77,
     -38,  39,-114,-113,  90,  10,  41,-100,  17, 127,  70,  23,
     -77,   5,   3, -71, -16, -77, -31,-107,  27, -90, -76,-116,
      86,  27, 112, -69,  12,  87,  42, -45,-107, -13,  10, -36,
     -98, -73,-108, -90, -53, 106, -59, -61, -74, 118,  26, -72,
      -9, -99,  41, -27,  94,  44,-113,  44, -18, -69, -12,  78,
     -86, -24, -51,   3, 119, -90,  95, -72, -69, 122, -84, 110,
     -78,-109,-106, 102, -14, -49, -17,  73, -85,  90,  77,  51,
      35,  92, -90,-108, -90,  42,  77,  33,-124,  89, 105, -90,
     105, -68, 126, -82,-101,  48, 119, -81, 125, -37, -20, -76,
     -86,  38, -35, -75,-118, -81,-102, -84, -25, -93,  29, 119,
      23, -32, -41,  78, 105,  61,  51,-113,  72,  39, -36, -74,
     -68,  37,  75, -36,  93,  -2, -84,   7, -90,  70, 115, -58,
     -16,  26,  38, -89, -98, 104, 103, 120, -12, -40, 119,-109,
      88, -78, -45, 112, -43,  25, -90, -92,-117,  47, 122,  93,
     -52,  68, 113, -67,  22, -35,   8,   2,-100, -13,-123,  23,
      29, -39, -41, -26,  45, -17,  29, -75,-122, -13,  10,  62,
      52, -59, -28, -79, -39,  26,-116,  75,   5,  55, -33, -96,
     -63,  -6, -36,  97,-100,-116, -29,-101,  30, 125,  61, -53,
     110,  30,-105,  44,  -9, -99, -78, 125, -41,  18,  43, 120,
     -28, -66, -31,-100, -77, -99, 120, -57,  23,  54, -27,-107,
      99, -86, -74, 124, -44, -55, -84,  35,-115, -30,  89, -68,
     -14, -35,  29, -33,  60,  58,-102,-114,  39,  95, 119, -19,
     -34, -97,-116,  44, -40,-118,   3, -49,  28,  -8, -80,-109,
      -8, -33, -58, 115,   7, -70, 125, -29,  47,  10,  10, -26,
      78,-110, -67, 123, -21, -47,  96,  -5,-115,  63, -92,  70,
    -117, -21, 126,-112,-100, -46,  22,   0, -87, -25, -65, -58,
     -79, -17,  59,  -6,  43,  12, -18, -56, -42, -75, -60, -11,
     -56, 123,   7,-116, -47, -27, -40,  19,  62, -27, -91, -81,
      49,  23, -84, -96,   3, 127,  87,  62, -50, -56,-115, 121,
      28, -84,  30,   8,  89, -93, -66,   3, -75, -56,-126, -63,
      35, -31, -80,  58,  53,  39,  98, -99,  77,-123,  34, -84,
     -32,   9,  41,-104,  66,  24,-102, -81,-122,  45, -44, -48,
       6, 109,  -8, -85,  99,  45, 107,-121,  44,  54,  84, -50,
     -13,  30,  24, -84,  32,  86,  72,  49,  67,  28,  97,   4,
      85,  40, -90, -17, -59,  11,-120,  70, -60,  97, 102,  48,
      23, -59,  27, -14,   4, 117,  85, -52,  98, -82, -76, -56,
     -59,  37,  82,  36,  32,   0,  59 };

  private ImageIcon logo = new ImageIcon(logodata);

  /*------------------------------------------------------------------*/

  public Dimension getPreferredSize ()
  { return new Dimension(logo.getIconWidth(), logo.getIconHeight()); }

  public void paint (Graphics g)
  { g.drawImage(logo.getImage(), 0, 0, this); }

}  /* class LogoPanel */
