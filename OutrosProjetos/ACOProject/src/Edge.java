
/*--------------------------------------------------------------------*/
class Edge implements Comparable {
/*--------------------------------------------------------------------*/

  /* --- instance variables --- */
  protected int i, j;           /* indices of connected vertices */
  protected int c;              /* color index */

  /*------------------------------------------------------------------*/

  public Edge () {}

  public Edge (int i, int j, int c)
  { this.i = i; this.j = j; this.c = c; }

  /*------------------------------------------------------------------*/

  public int compareTo (Object obj)
  {                             /* --- compare two edges */
    if (this.c < ((Edge)obj).c) return -1;
    if (this.c > ((Edge)obj).c) return +1;
    return 0;                   /* return sign of color difference */
  }  /* compareTo() */

}  /* class Edge() */