
import svg.*; 
import jus.util.Calcul ;

public class Canon{
    private double angle = -45; 
    private Trait canon; 
    private double force = 50; 
    private int nbTirs = 0; 
    private Cercle roue; 
    private Texte score; 
    private double x = 200; 
    private double y = 200; 
    Ecran e= new Ecran();
    public int touche;
    private int gauche=37;
    private int haut=38;
    private int droite= 39;
    private int bas=40;
    private int espace=32; 
    
    public Canon(double x, double y){
        canon = new Trait(this.x, this.y, this.x + 40, this.y, "noir", 1, 14);
        roue = new Cercle(this.x, this.y, 12, "noir", 1, "noir", 1);
        score = new Texte(this.x + 1, this.y + 6, "" + nbTirs, 16, "gris", 1, "Comic Sans MS");
        score.centrer();
        canon.angle(angle); 
    }
    
        public Canon(){
        this(200,200); 
    }
    
    public Point bout(){
        return canon.p2();
    }
    
    public void regler(){
        double lng = 50;
        Texte valAngle=new Texte(bout().x(),bout().y(),(angle+90)+"",10,"noir",1,"Comic Sans MS");
        Rectangle valForce = new Rectangle(x - 10,y + 15, force, 4, "gris", 1, "noir", 1); 
        Rectangle jauge = new Rectangle(x - 10,y + 15,lng , 4, "gris", 0.5, "noir", 1);
        int touche = e.toucheAppuyee();  
        while(touche != espace){
            e.toucheAppuyee = 0;
            // if(angle > 0) {angle = 0;}
            // else if(angle < -90) {angle = -90;}
            if (touche == haut) {
                angle += 5;
            } else if (touche == bas) {
                angle -= 5;
            } else if (touche == droite) {
                if(force < 100){
                    force += 1;}
            } else if (touche == gauche) {
                if (force > 0){ 
                    force -= 1; } 
            }
            canon.angle(angle); 
            valAngle.ecrire("" + (angle + 90)); 
            valForce.largeur(force/100 * lng); 
            touche = e.toucheAppuyee();
        }
        valForce.supprime();
        jauge.supprime();
        valAngle.ecrire("");
        touche=0;
    }
    
    public void tirer(Boulet b, Cible c){
        nbTirs++;
        score.ecrire(nbTirs+"");
        Calcul cal = new Calcul();
        // angle = (angle+90) * cal.PI()/180; 
        double forceH = -1*force*cal.sin(angle/180*cal.PI()); 
        double forceV = -1*force*cal.cos(angle/180*cal.PI());
        b.placer(bout().x(), bout().y());
        b.lancer(forceH, forceV, c);
    }

}








