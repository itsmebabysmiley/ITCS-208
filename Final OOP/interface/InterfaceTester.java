
interface Sugar{
    abstract void sugarUsage();
}
interface Water{
    abstract void waterUsage();
}

class Coffee implements Sugar , Water {
    @Override
    public void sugarUsage() {
        System.out.println("Use for coffee");
    }
    @Override
    public void waterUsage() {
        System.out.println("Use of water");
    }
    
}
/**
 * syrup
 */
class Syrup implements Sugar {
    @Override
    public void sugarUsage() {
        System.out.println("Use for Syrup");
    }
}
    

/**
 * Appmain
 */
class InterfaceTester {

    public static void main(String[] args) {
        useofSugar(new Syrup());
        useofSugar(new Coffee());
        useofWater(new Coffee());

    }
    static void useofSugar(Sugar sugar) {
        sugar.sugarUsage();
        
    }
    static void useofWater(Water water){
        water.waterUsage();
    }
}


