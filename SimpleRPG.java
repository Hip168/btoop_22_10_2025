import java.util.ArrayList;
import java.util.List;

/**
 * @brief Lớp cơ sở trừu tượng (abstract class) cho tất cả nhân vật.
 * Mỗi nhân vật phải có các thông tin cơ bản[cite: 5].
 */
abstract class Character {
    protected String name; // Tên [cite: 6]
    protected int hp; // Máu (HP) [cite: 7]
    protected int baseDamage; // Sát thương cơ bản [cite: 8]

    // Constructor để khởi tạo thông tin cơ bản
    public Character(String name, int hp, int baseDamage) {
        this.name = name;
        this.hp = hp;
        this.baseDamage = baseDamage;
    }

    /**
     * @brief Hành động tấn công.
     * Mỗi nhân vật phải có hành động tấn công (attack)[cite: 9].
     * Đây là một phương thức trừu tượng (abstract method),
     * bắt buộc các lớp con phải định nghĩa lại (override).
     */
    public abstract void attack();

    public String getName() {
        return name;
    }
}

/**
 * @brief Lớp Warrior (Chiến binh)
 * Tấn công bằng vũ khí cận chiến[cite: 4].
 */
class Warrior extends Character {
    public Warrior(String name, int hp, int baseDamage) {
        super(name, hp, baseDamage);
    }

    // Định nghĩa lại (override) hành động attack
    // Ví dụ: Arthur (Warrior) attacks with a sword! [cite: 14]
    @Override
    public void attack() {
        System.out.println(name + " (Warrior) attacks with a sword!");
    }
}

/**
 * @brief Lớp Archer (Cung thủ)
 * Tấn công tầm xa[cite: 4].
 */
class Archer extends Character {
    public Archer(String name, int hp, int baseDamage) {
        super(name, hp, baseDamage);
    }

    // Định nghĩa lại (override) hành động attack
    // Ví dụ: Legolas (Archer) shoots an arrow! [cite: 14]
    @Override
    public void attack() {
        System.out.println(name + " (Archer) shoots an arrow!");
    }
}

/**
 * @brief Lớp Mage (Pháp sư)
 * Tấn công bằng phép thuật[cite: 4].
 */
class Mage extends Character {
    public Mage(String name, int hp, int baseDamage) {
        super(name, hp, baseDamage);
    }

    // Định nghĩa lại (override) hành động attack
    // Ví dụ: Gandalf (Mage) casts a fireball! [cite: 14]
    @Override
    public void attack() {
        System.out.println(name + " (Mage) casts a fireball!");
    }
}

/**
 * @brief Lớp ArcaneArcher (Cung thủ phép)
 * Có thể bắn tầm xa và dùng phép thuật[cite: 4, 10].
 */
class ArcaneArcher extends Character {
    public ArcaneArcher(String name, int hp, int baseDamage) {
        super(name, hp, baseDamage);
    }

    /**
     * @brief Định nghĩa lại (override) hành động attack.
     * Nếu nhân vật có kỹ năng phụ thì phải thực hiện nó[cite: 12].
     */
    @Override
    public void attack() {
        // Ví dụ: Sylvanas (ArcaneArcher) shoots an arrow! [cite: 15]
        System.out.println(name + " (ArcaneArcher) shoots an arrow!");
        // Ví dụ: Sylvanas also casts a magic spell! [cite: 15]
        System.out.println(name + " also casts a magic spell!");
    }
}

/**
 * @brief Lớp chính chứa hàm main để chạy chương trình.
 */
public class SimpleRPG {
    
    /**
     * @brief Hàm main của chương trình.
     * Trong hàm main, tạo danh sách các nhân vật khác nhau[cite: 11].
     */
    public static void main(String[] args) {
        
        // Tạo danh sách (List) các nhân vật [cite: 11]
        List<Character> characters = new ArrayList<>();

        // Thêm các nhân vật vào danh sách
        characters.add(new Warrior("Arthur", 150, 20));
        characters.add(new Archer("Legolas", 100, 15));
        characters.add(new Mage("Gandalf", 80, 25));
        characters.add(new ArcaneArcher("Sylvanas", 120, 18));

        System.out.println("--- Character Attacks ---");

        // ...rồi cho họ thực hiện hành động tấn công liên tiếp[cite: 11].
        // Duyệt qua danh sách và gọi hành động attack() của mỗi nhân vật
        for (Character character : characters) {
            character.attack(); // Tính đa hình (polymorphism) được thể hiện ở đây
        }
    }
}