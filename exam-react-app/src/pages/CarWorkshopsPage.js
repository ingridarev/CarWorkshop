import { useState, useEffect, useContext } from "react";
import { Link, NavLink } from "react-router-dom";
import { Card, Container, Button } from "semantic-ui-react";
import AuthContext from "../AuthContext";
import "./carWorkshopsPage.css";

export function CarWorkshopsPage() {
  const { appState, setAppState } = useContext(AuthContext);

  const [carWorkshops, setCarWorkshops] = useState([]);

  const fetchCarWorkshops = async () => {
    fetch("/api/v1/carWorkshops")
      .then((response) => response.json())
      .then((jsonResponse) => setCarWorkshops(jsonResponse));
  };

  useEffect(() => {
    fetchCarWorkshops();
  }, []);

  return (
    <Container className="carWorkshops mt-5">
      <Card.Group>
        {carWorkshops.map((workshop) => (
          <Card className="card" key={workshop.id}>
            <Card.Content>
              <Card.Header>{workshop.title}</Card.Header>
              <Card.Description>{workshop.description} </Card.Description>
              <Card.Description>
                <Button 
                as={NavLink} 
                exact to={"/carWorkshops/" + workshop.id}
                >
                  Rinktis servisą
                </Button>{" "}
              </Card.Description>
            </Card.Content>
          </Card>
        ))}
      </Card.Group>

    </Container>
  );
}
