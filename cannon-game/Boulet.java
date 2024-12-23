

import svg.*; 
public class Boulet{
    private double altitudeZero; 
    private Cercle boulet; 
    private double masse; 
    private double x; 
    private double xV; 
    private double y; 
    private double yV;
    
    public Boulet(){
        this(100,100,1,300);
    }
    
    public Boulet(double x, double y, double m, double alt0){
        boulet = null;  
        this.x = x; 
        this.y = y; 
        masse = m; 
        altitudeZero = alt0; 
    }
    
    public void placer(double x, double y){
        this.x = x; 
        this.y = y; 
    }

    public void lancer(double xV0, double yV0, Cible cible){
        double t = 0, dt = 0.01, g = 9.8, dx,dy; 
        Ecran e = new Ecran(); 
        Cercle boulet = new Cercle(x,y,2*masse, "noir", 1, "noir", 1);
        cible.atteinte = false;
        System.out.println("Lancement du boulet");
        while(y < altitudeZero && !cible.atteinte){
            xV = xV0;
            yV = g * t + yV0;
            dx = xV*dt;
            dy = yV*dt;
            x += dx;
            y += dy;
            t += dt;
            e.pause((int)(dt*100));
            boulet.place(x,y);
            cible.toucher(x,y);
        }
        System.out.println("Fin du lancement");
        boulet.supprime();
    }
    
    public static void main(){
        Cible cible = new Cible();
        Boulet boulet = new Boulet();
        boulet.lancer(30,-30,cible);
    }
}
