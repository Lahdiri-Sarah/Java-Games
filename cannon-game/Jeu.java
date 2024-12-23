


import svg.*; 
public class Jeu{
    private Boulet boulet; 
    private Canon canon; 
    private Cible cible; 
    private Ecran e; 
    public int touche;
    private int gauche=37;
    private int haut=38;
    private int droite= 39;
    private int bas=40;
    private int espace=32; 
    private int entree=10;
    
    public Jeu(){
        e = new Ecran();
        boulet = new Boulet(0,0,3,500); 
        canon = new Canon(25, e.hauteur()/2);  
        cible = new Cible();
    }
    
    public void jouer(){
        touche = e.toucheAppuyee(); 
        while (touche != entree){ 
            e.toucheAppuyee = 0;
            if(touche == espace){
                touche = 0;
                canon.tirer(boulet,cible);
            }
            else{
                touche = 0;
                canon.regler();
            }
            touche = e.toucheAppuyee();
        }
    }
    
    public static void main(){
        Jeu j = new Jeu(); 
        j.jouer();
    }
}
