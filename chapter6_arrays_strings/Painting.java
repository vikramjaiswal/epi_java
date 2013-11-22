import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Painting
{
    private static class Coordinate
    {
        int r;
        int c;
        boolean value;
        
        Coordinate(int mr, int mc, boolean mvalue)
        {
            r = mr;
            c = mc;
            value = mvalue;
        }
        
        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + c;
            result = prime * result + r;
            result = prime * result + (value ? 1231 : 1237);
            return result;
        }
        
        @Override
        public String toString()
        {
            return "Coordinate [r=" + r + ", c=" + c + ", value=" + value + "]";
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Coordinate other = (Coordinate) obj;
            if (c != other.c)
                return false;
            if (r != other.r)
                return false;
            if (value != other.value)
                return false;
            return true;
        }
        
    }
    
    // y=row; x=col 0,0 is top left
    
    public static void paint(boolean[][] m, int x, int y)
    {
        Set<Coordinate> connectedRegionVisited = bfsConnectedRegion(m, x, y);
        
        boolean svalFlip = !m[y][x];
        
        for (Coordinate c : connectedRegionVisited)
        {
            
            m[c.r][c.c] = svalFlip;
        }
    }
    
    private static Set<Coordinate> bfsConnectedRegion(boolean[][] m, int x, int y)
    {
        Set<Coordinate> visited = new HashSet<Coordinate>();
        
        int sr = y;
        int sc = x;
        boolean sval = m[sr][sc];
        
        Queue<Coordinate> q = new ArrayDeque<Coordinate>();
        
        q.add(new Coordinate(sr, sc, sval));
        
        while (!q.isEmpty())
        {
            Coordinate currentC = q.remove();
            visited.add(currentC);
            
            // add all connected neighbours of currentC and add to the Queue
            Coordinate top = getNeighbourTop(currentC, m);
            if (top != null && !visited.contains(top))
                q.add(top);
            
            Coordinate bottom = getNeighbourBottom(currentC, m);
            if (bottom != null && !visited.contains(bottom))
                q.add(bottom);
            
            Coordinate left = getNeighbourLeft(currentC, m);
            if (left != null && !visited.contains(left))
                q.add(left);
            
            Coordinate right = getNeighbourRight(currentC, m);
            if (right != null && !visited.contains(right))
                q.add(right);
        }
        
        return visited;
    }
    
    private static Coordinate getNeighbourTop(Coordinate currentC, boolean[][] a)
    {
        int tr = currentC.r - 1;
        int tc = currentC.c;
        
        if (tr < 0)
            return null;
        
        if (a[tr][tc] != currentC.value)
            return null;
        
        return new Coordinate(tr, tc, a[tr][tc]);
    }
    
    private static Coordinate getNeighbourBottom(Coordinate currentC,
            boolean[][] a)
    {
        
        int tr = currentC.r + 1;
        int tc = currentC.c;
        
        if (tr >= a.length)
            return null;
        
        if (a[tr][tc] != currentC.value)
            return null;
        
        return new Coordinate(tr, tc, a[tr][tc]);
    }
    
    private static Coordinate getNeighbourLeft(Coordinate currentC,
            boolean[][] a)
    {
        
        int tr = currentC.r;
        int tc = currentC.c - 1;
        
        if (tc < 0)
            return null;
        
        if (a[tr][tc] != currentC.value)
            return null;
        
        return new Coordinate(tr, tc, a[tr][tc]);
    }
    
    private static Coordinate getNeighbourRight(Coordinate currentC,
            boolean[][] a)
    {
        
        int tr = currentC.r;
        int tc = currentC.c + 1;
        
        if (tc >= a[0].length)
            return null;
        
        if (a[tr][tc] != currentC.value)
            return null;
        
        return new Coordinate(tr, tc, a[tr][tc]);
    }
    
    public static void main(String[] args)
    {
        boolean F = false; 
        boolean T = true;
        
        /*
        boolean[][] m = new boolean[][]{ 
                { F, F, F, F, T}, 
                { T, F, F, F, F}, 
                { T, T, T, F, F},
                { F, F, F, F, F},
                { F, F, F, T, F},
                { F, F, F, F, F},                
                };*/
        
        
        boolean[][] m = new boolean[][]{ 
                { T,F,T,F,F,F,T,T,T,T},
                { F,F,T,F,F,T,F,F,T,T},
                { T,T,T,F,F,T,T,F,T,T},                
                { F,T,F,T,T,T,T,F,T,F},                
                { T,F,T,F,F,F,F,T,F,F},
                { T,F,T,F,F,T,F,T,T,T},
                { F,F,F,F,T,F,T,F,F,T},
                { T,F,T,F,T,F,T,F,F,F},
                { T,F,T,T,F,F,F,T,T,T},
                { F,F,F,F,F,F,F,T,T,F}
                };
        
        
        
        
        log (m);
        
        int pr = 5;
        int pc = 4;        
        
        paint(m,  pc, pr);
        log (m);
        
        paint(m,  pc, pr);
        log (m);
        
        
    }
    
    
    private static void log(boolean[][] m)
    {
        int nrows = m.length;
        int ncols = m[0].length;
        
        for (int r=0; r < nrows; r++ ){
            
            System.out.print("|");
            
            for (int c=0; c < ncols; c++ ){
                
                if (m[r][c])
                    System.out.print("X ");
                else
                    System.out.print("O ");                    
            }
            
            System.out.print("|\n");
        }
        
        System.out.println("**********************");
        
    }
    
    
    private static void log(Object object)
    {
        
    }
}
