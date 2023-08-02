package familyTree;

import familyTree.human.Gender;
import familyTree.human.Human;
import familyTree.FamilyTree;

import java.time.LocalDate;


public class Main  {
public static void main(String[] args) {

FamilyTree<Human> tree = testTree();
System.out.println(tree);
FileHandler f1=new FileHandler();

// Сериализация объекта в файл

f1.serializeObject(tree, "person.out");

// Десериализация объекта из файла
FamilyTree<Human> treeRestored = (FamilyTree<Human>) f1.deserializeObject("person.out");
System.out.println(treeRestored);
tree.sortByName();
System.out.println(tree);
tree.sortByBirthDate();
System.out.println(tree);

}
static FamilyTree<Human> testTree() {
    FamilyTree<Human> tree = new FamilyTree<>();
    Human Sasha = new Human("Александр", Gender.Male, LocalDate.of(1976, 9, 19));
    Human Lena = new Human("Елена", Gender.Female, LocalDate.of(1987, 3, 1));
    tree.add(Sasha);
    tree.add(Lena);
    tree.setWedding(Sasha.getId(), Lena.getId());

    Human Nadya = new Human("Надежда", Gender.Female, LocalDate.of(2023, 12, 10), Sasha, Lena);
    Human Gena = new Human("Геннадий", Gender.Male, LocalDate.of(2022, 1, 14), Sasha, Lena);
    tree.add(Nadya);
    tree.add(Gena);

    Human Nina = new Human("Нина", Gender.Female, LocalDate.of(1942, 7, 8));
    tree.add(Nina);
    return tree;
}
  
    
}






