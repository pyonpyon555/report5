package jp.ac.uryukyu.ie.e175762;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy extends LivingThing {
    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     *
     * @param name      モンスター名
     * @param maximumHP モンスターのHP
     * @param attack    モンスターの攻撃力
     */
    public Enemy(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }
        /*this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }*/

        /**
         * getterメソッドと同等。生死をboolean表現しているためメソッド名をisDead()とした。
         * @return boolean
         */

        /**
         * Heroへ攻撃するメソッド。
         * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
         * @param hero 攻撃対象
         */


        /**
         * 自身へ攻撃されたときのダメージ処理をするメソッド。
         * 指定されたダメージを hitPoint から引き、死亡判定を行う。
         * @param damage 受けたダメージ
         */

    public void wounded(int damage) {
        setHitPoint(getHitPoint() - damage);
        if (getHitPoint() <= 0) {
            setDead(true);
            System.out.printf("%sは倒れた。\n", getName());
        }

    }
    @Override
    public void attack(LivingThing opponent) {
        int damage = (int) (Math.random() * getAttack());
        int critical = (int)(Math.random() * 100);
        if (isDead() == false) {
            if (critical < 30) {
                if (damage == 0) {
                    System.out.printf("%sの攻撃！痛恨の一撃！！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName(), damage * 2);
                } else {
                    System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage * 2);
                    opponent.wounded(damage);
                }
            }else{
                if (damage == 0) {
                    System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName(), damage);
                } else {
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                    opponent.wounded((damage));
                }
            }
        }
    }
}