import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import { React, useContext, useState, useEffect } from "react";
import { Container, Menu, Button } from "semantic-ui-react";
import { Link, useNavigate } from "react-router-dom";
import AuthContext from "../AuthContext";
import { AddMenu } from "../pages/AddCarWorkshop";

export function TopMenu() {
  const { appState, setAppState } = useContext(AuthContext);
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [menus, setMenus] = useState([]);

  const logoutHandler = async () => {
    fetch("/logout", {
      method: "POST",
    }).then((response) => {
      setAppState({ type: "LOGOUT" });
      navigate("/", { replace: true });
    });
  };

  return (
    <Navbar bg="secondary" variant="light">
      <Container>
        <Nav className="d-flex">
          <Link className="text-decoration-none me-auto mt-2" to={"/"}>
            <Navbar.Brand href="#home">Automobilių servisai</Navbar.Brand>
          </Link>

          {/* <Link className="text-decoration-none" to={"menus/"}>
            <Nav.Link href="#menu">Pasirinkti meniu</Nav.Link>
          </Link> */}

          {appState.isAuthenticated && (
            <Link className="text-decoration-none" to={"menus/create"}>
              <Nav.Link href="#create">
                {" "}
                Pridėti meniu
              </Nav.Link>
            </Link>
          )}
          {!appState.isAuthenticated && (
            <Link className="text-decoration-none" to={"login/"}>
              <Nav.Link href="#login">Prisijungti</Nav.Link>
            </Link>
          )}

          {appState.isAuthenticated && (
            <Link className="text-decoration-none" to={"menus/"}>
              <Nav.Link href="#logout" onClick={logoutHandler}>
                Atsijungti
              </Nav.Link>
            </Link>
          )}
        </Nav>
      </Container>
    </Navbar>
  );
}
