package jp.ac.uryukyu.ie.e195702;



public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * HeroとEnemyのステータスメソッド
     * HeroとEnemyの持っている名前、HP、攻撃力を保存し出力する。
     * @param name
     * @param maximumHP
     * @param attack
     */

    public LivingThing(String name, int maximumHP, int attack){
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    public void setDead(boolean dead){
        this.dead = dead;
    }

    public boolean isDead() {
        return dead;
    }

    public String getName(){
        return name;
    }

    public int getHitPoint(){
        return hitPoint;
    }

    public int getAttack(){
        return attack;
    }

    /**
     * 攻撃メソッド
     * 攻撃する際にランダムの数字のダメージを与える。
     * @param opponent
     */


    public void attack(LivingThing opponent){
        if (!isDead()) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * 生死判定メソッド
     * Hpが0以下になると死亡したことを表す。
     * @param damage
     */

    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint <= 0 ) {
            dead = true;
            System.out.printf("%sは道半ばで力尽きてしまった。\n", name);
        }
    }




}