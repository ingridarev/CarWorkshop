import { useState, useEffect, useContext } from "react";
import { Link, NavLink } from "react-router-dom";
import { Card, Container, Button, Icon, Confirm } from "semantic-ui-react";
import AuthContext from "../AuthContext";
import "./carWorkshopsPage.css";

export function CarWorkshopPage() {
  const { appState, setAppState } = useContext(AuthContext);

  const [carWorkshops, setCarWorkshops] = useState([]);
  const [open, setOpen] = useState(false);

  const fetchCarWorkshops = async () => {
    fetch("/api/v1/carWorkshops")
      .then((response) => response.json())
      .then((jsonResponse) => setCarWorkshops(jsonResponse));
  };

  const deleteCarWorkshop = async (id) => {
    fetch(`/api/v1/carWorkshops/` + id, {
      method: "DELETE",
    })
      .then((response) => {
        if (response.ok) {
          const updatedWorkshops = carWorkshops.filter(
            (workshop) => workshop.id !== id
          );
          setCarWorkshops(updatedWorkshops);
        }
      })
      .catch((error) => {
        console.error("Error deleting car workshop:", error);
      });
  };

  useEffect(() => {
    fetchCarWorkshops();
  }, []);

  return (
    <Container className="carWorkshops mt-5">
      <Card.Group centered>
        {carWorkshops.map((workshop) => (
          <Card className="card" key={workshop.id}>
            <Card.Content className="centered">
              <Card.Header>{workshop.title}</Card.Header>
              <Card.Description>{workshop.address} </Card.Description>
              <Card.Content extra>
                <a>
                  <Icon name="user" />
                  Vadovas - {workshop.manager}
                </a>
              </Card.Content>
              <Card.Description>
                <Button
                  className="mt-2"
                  as={NavLink}
                  exact
                  to={"/carWorkshops/" + workshop.id}
                  style={{
                    color: "black",
                    backgroundColor: "transparent",
                    border: "1px solid black",
                  }}
                >
                  Rinktis servisą
                </Button>
                <Button
                  onClick={() => setOpen(workshop.id)}
                  className="mt-2 trash"
                  style={{
                    color: "black",
                    backgroundColor: "transparent",
                    border: "1px solid black",
                  }}
                >
                  <Icon name="trash" size="small" />
                </Button>
              </Card.Description>
            </Card.Content>
          </Card>
        ))}
      </Card.Group>
      <Container centered>
          <Confirm
            open={open}
            header="Dėmesio!"
            content="Ar tikrai norite ištrinti?"
            cancelButton="Grįžti atgal"
            confirmButton="Taip"
            onCancel={() => setOpen(false)}
            onConfirm={() => deleteCarWorkshop(open).then(setOpen(false))}
            size="small"
          />
      </Container>
    </Container>
  );
}
