import { useReducer } from "react";
import { HashRouter, Route, Routes } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import { TopMenu } from "./components/TopMenu";
import { Container } from "semantic-ui-react";
import AuthContext from "./AuthContext";
import Authentication from "./Authentication";
import { ViewMenuMeals } from "./pages/ViewMenuMeals";
import { LoginPage } from "./pages/LoginPage";
import "semantic-ui-css/semantic.min.css";
import { AddCarWorkshop } from "./pages/AddCarWorkshop";
import { AddRepairman } from "./pages/AddRepairman";
import { CarWorkshopsPage } from "./pages/CarWOrkshopsPage";

function App() {
  var initState = {
    isAuthenticated: false,
    username: null,
    role: null,
  };

  const auth = (appState, action) => {
    switch (action.type) {
      case "LOGIN":
        return {
          ...appState,
          isAuthenticated: true,
          username: action.value.username,
          role: action.value.role,
        };
      case "LOADING":
        return {
          ...appState,
          isLoading: action.value,
        };
      case "LOGOUT":
        return {
          ...appState,
          isAuthenticated: false,
          username: null,
          role: null,
        };
      case "AUTHENTICATED":
        return {
          ...appState,
          isAuthenticated: true,
          admin: true,
        };
      default:
        return appState;
    }
  };
  const [appState, setAppState] = useReducer(auth, initState);

  return (
    <div>
      <Container>
        <AuthContext.Provider value={{ appState, setAppState }}>
          <HashRouter>
            <TopMenu />
            <div className="container">
              <Routes>
                <Route path="/carWorkshops/" element={<CarWorkshopsPage />} />
                <Route path="/menus/:id" element={<ViewMenuMeals />} />
                <Route path="/login/" element={<LoginPage />} />
                <Route path="/carWorkshops/create" element={<AddCarWorkshop />} />
                <Route path="/repairmans/create/:id" element={<AddRepairman />} />
              </Routes>
            </div>
          </HashRouter>
        </AuthContext.Provider>
      </Container>
    </div>
  );
}

export default App;
