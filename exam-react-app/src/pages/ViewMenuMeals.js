import { useEffect, useState, useContext } from "react";
import { useParams, Link } from "react-router-dom";
import { Card, Container, Button, Table } from "semantic-ui-react";
import AuthContext from "../AuthContext";

export function ViewMenuMeals() {
  const { appState, setAppState } = useContext(AuthContext);
  const [menu, setMenu] = useState({});
  const [meals, setMeals] = useState([]);

  const params = useParams();

  const fetchMenu = () => {
    fetch(`/api/v1/meals/all/${params.id}`)
      .then((response) => response.json())
      .then(setMeals);
  };

  useEffect(() => {
    fetch(`/api/v1/meals/all/${params.id}`)
      .then((response) => response.json())
      .then(setMeals);
    console.log(menu);
  }, [params.id]);

  return (
    <div>
      <h1 className="text-center mt-3 mb-5">{menu.title}</h1>

      <Container className="menus mt-5">
        {appState.isAuthenticated && (
          <Link to={"/meals/create/" + params.id}>
            <Button
              className="text-decoration-none text-muted mt-3 mb-3"
              basic
              inverted
              color="black"
            >
              Pridėti patiekalą
            </Button>
          </Link>
        )}

        <Card.Group>
          {meals.map((meal) => (
            <Card className="card" key={meal.id}>
              <Card.Content>
                <Card.Header>{meal.title}</Card.Header>
                <Card.Description>{meal.description} </Card.Description>
                <Card.Description>
                  <Link
                    className="text-decoration-none text-muted"
                    // to={"meals/all/" + menu.id}
                  >
                    <Button>Užsakyti</Button>{" "}
                  </Link>
                </Card.Description>
              </Card.Content>
            </Card>
          ))}
        </Card.Group>
      </Container>
      <div>
        <Table celled className="mt-5">
          <Table.Header>
            <Table.Row>
              <Table.HeaderCell>Užsakymo id</Table.HeaderCell>
              <Table.HeaderCell>Patiekalai</Table.HeaderCell>
              <Table.HeaderCell>Kiekis</Table.HeaderCell>
            </Table.Row>
          </Table.Header>

          <Table.Body>
            <Table.Row>
              <Table.Cell>First</Table.Cell>
              <Table.Cell>Cell</Table.Cell>
              <Table.Cell>Cell</Table.Cell>
            </Table.Row>
            <Table.Row>
              <Table.Cell>Cell</Table.Cell>
              <Table.Cell>Cell</Table.Cell>
              <Table.Cell>Cell</Table.Cell>
            </Table.Row>
            <Table.Row>
              <Table.Cell>Cell</Table.Cell>
              <Table.Cell>Cell</Table.Cell>
              <Table.Cell>Cell</Table.Cell>
            </Table.Row>
          </Table.Body>
        </Table>
      </div>
    </div>
  );
}
