//package lt.techin.dao;
//
//import lt.techin.model.Menu;
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
//public class MenuRepositoryTests {
//    @Autowired
//    private MenuRepository menuRepository;
//
//    @Test
//    public void BlogPostRepository_SaveAll_ReturnsSavedBlogPost(){
//
//        Menu menu = new Menu();
//        menu.setTitle("testTitle");
//        menu.setText("testText");
//
//        Menu savedMenu = menuRepository.save(menu);
//
//        Assertions.assertThat(savedMenu).isNotNull();
//        Assertions.assertThat(savedMenu.getId()).isGreaterThan(0);
//
//    }
//
//    @Test
//    public void BlogPostRepository_GetAll_ReturnsMoreThanOnePokemon(){
//
//        Menu menu = new Menu();
//        menu.setTitle("testTitle");
//        menu.setText("testText");
//
//        Menu menu1 = new Menu();
//        menu1.setTitle("testTitle1");
//        menu1.setText("testText");
//
//
//        menuRepository.save(menu);
//        menuRepository.save(menu1);
//
//        List<Menu> menuList = menuRepository.findAll();
//
//        Assertions.assertThat(menuList).isNotNull();
//        Assertions.assertThat(menuList.size()).isGreaterThan(2);
//    }
//
//    @Test
//    public void BlogPostRepository_FindById_ReturnsBlogPost(){
//
//        Menu menu = new Menu();
//        menu.setTitle("testTitle");
//        menu.setText("testText");
//
//
//        menuRepository.save(menu);
//
//
//        Menu menuById = menuRepository.findById(menu.getId()).get();
//
//        Assertions.assertThat(menuById).isNotNull();
//
//    }
//
//    @Test
//    public void BlogPostRepository_findAllByOrderByCreatedDateDesc_ReturnsBlogPost(){
//
//        Menu menu = new Menu();
//        menu.setTitle("testTitle");
//        menu.setText("testText");
//
//
//        menuRepository.save(menu);
//
//
//        List<Menu> menuList = menuRepository.findAllByOrderByCreatedDateDesc();
//
//        Assertions.assertThat(menuList).isNotNull();
//
//    }
//}
