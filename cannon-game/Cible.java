
import svg.*; 

public class Cible{
    public boolean atteinte = false; 
    private Rectangle cible; 
    private int nbTouches = 0; 
    private Texte score; 
    private double x; 
    private double y;
    private Ecran e = new Ecran() ;
    
    public Cible(){
        x = e.tirageAleatoire(90,e.largeur()); 
        y = e.tirageAleatoire(10,e.hauteur()); 
        nbTouches = 0; 
        atteinte = false; 
        cible = new Rectangle(x, y, 50, 15, "rouge", 1, "noir", 1); 
        score = new Texte(x + cible.largeur()/2, cible.hauteur()/2 + y + 5, "" + nbTouches, 12, "blanc", 1 ,"Comic Sans MS"); 
        score.centrer(); 
    }
    
    public void bouge(){
        x = e.tirageAleatoire(90,e.largeur()); 
        y = e.tirageAleatoire(10,e.hauteur());
        cible.supprime();
        cible = new Rectangle(x, y, 50, 15, couleur(), 1, "noir", 1); 
        cible.place(x, y); 
        score.ecrire(x + cible.largeur()/2, cible.hauteur()/2 + y + 5); 
    }
    
    public String couleur(int c){
        if(c == 1){ return "rouge";}
        if(c == 2){ return "bleu";}
        if(c == 3){ return "jaune";}
        if(c == 4){ return "vert";}
        if(c == 5){ return "magenta";}
        if(c == 6){ return "cyan";}
        if(c == 7){ return "orange";}
        else { return "gris";}
    }
    
    public String couleur(){
        int n = e.tirageAleatoire(1,8); 
        return couleur(n);
    }
    
    public void toucher(double x, double y){
        if(cible.inclus(x,y)){
            atteinte = true;
            nbTouches += 1; 
            score.ecrire("" + nbTouches); 
            score.centrer();
            bouge();
        }
    }
    
}
