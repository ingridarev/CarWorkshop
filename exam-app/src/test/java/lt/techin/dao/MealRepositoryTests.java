//package lt.techin.dao;
//
//import lt.techin.model.Menu;
//import lt.techin.model.Meal;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.List;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
//public class MealRepositoryTests {
//
//
//    private MealRepository mealRepository;
//    private MenuRepository menuRepository;
//
//    @Autowired
//
//    public MealRepositoryTests(MealRepository mealRepository, MenuRepository menuRepository) {
//        this.mealRepository = mealRepository;
//        this.menuRepository = menuRepository;
//    }
//
//    @Test
//    public void CommentRepository_SaveAll_ReturnsSavedComment(){
//
//        Meal meal = new Meal();
//        meal.setAuthor("authorTest");
//        meal.setText("textTest");
//
//        Meal savedMeal = mealRepository.save(meal);
//
//        Assertions.assertThat(savedMeal).isNotNull();
//        Assertions.assertThat(savedMeal.getId()).isGreaterThan(0);
//
//    }
//
//    @Test
//    public void CommentRepository_GetAll_ReturnsMoreThanOnePokemon(){
//
//        Meal meal = new Meal();
//        meal.setAuthor("testAuthor");
//        meal.setText("testText");
//
//        Meal meal1 = new Meal();
//        meal1.setAuthor("testAuthor1");
//        meal1.setText("testText");
//
//
//        mealRepository.save(meal);
//        mealRepository.save(meal1);
//
//        List<Meal> commentsList = mealRepository.findAll();
//
//        Assertions.assertThat(commentsList).isNotNull();
//        Assertions.assertThat(commentsList.size()).isGreaterThan(2);
//    }
//
//    @Test
//    public void MealRepository_FindById_ReturnsMeal(){
//
//        Meal meal = new Meal();
//        meal.setAuthor("testAuthor");
//        meal.setText("testText");
//
//        mealRepository.save(meal);
//
//
//       Meal mealById = mealRepository.findById(meal.getId()).get();
//
//        Assertions.assertThat(mealById).isNotNull();
//    }
//
//    @Test
//    public void MealRepository_GetAllByMenu_IdOrderByCreatedDateDesc_ReturnsMealNotNull(){
//
//        Meal meal = new Meal();
//        meal.setAuthor("testAuthor");
//        meal.setText("testText");
//
//        Menu menu = new Menu();
//        menu.setTitle("testTitle");
//        menuRepository.save(menu);
//        meal.setMenu(menu);
//
//        mealRepository.save(meal);
//
//        List<Meal> mealList = mealRepository.getAllByMenu_IdOrderByCreatedDateDesc(menu.getId());
//
//        Assertions.assertThat(mealList).isNotNull();
//    }
//
//}
