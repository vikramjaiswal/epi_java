public class IntersectRectangle
{
    
    private static class Rectangle
    {
        int x, y, width, height;
        
        Rectangle(int x, int y, int width, int height)
        {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
        
        public String toString() {
            
            StringBuilder sb = new StringBuilder();
            
            sb.append("(" + x);
            sb.append(", " + y);
            sb.append(", " + width);
            sb.append(", " + height + ")");
            
            return sb.toString();
        }
    }
    
    public static boolean isIntersect(Rectangle r, Rectangle s)
    {
        boolean intersect = (r.x <= (s.x + s.width))  &&
                            (s.x <= (r.x + r.width)) && 
                            (r.y <= (s.y + s.height) ) && 
                            (s.y <= (r.y + r.height) );
        
        return intersect;
    }

    
    public static Rectangle intersectRectangle(Rectangle R, Rectangle S) {
        
        
        if (isIntersect(R, S)) {
            
          return new Rectangle (Math.max(R.x, S.x),
                  Math.max(R.y, S.y),
                  Math.min(R.x + R.width, S.x + S.width) - Math.max(R.x, S.x),
                  Math.min(R.y + R.height, S.y + S.height) - Math.max(R.y, S.y));
        } else {
          return new Rectangle(0, 0, -1, -1);  // no intersection.
        }
      }    
    
    
    
    public static void main(String[] args)
    {
        Rectangle r = new Rectangle(0, 0, 4, 4);
        Rectangle s = new Rectangle(1, 1, 10, 10);
        
        log (intersectRectangle(r,s));
    }
    
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
    
}
