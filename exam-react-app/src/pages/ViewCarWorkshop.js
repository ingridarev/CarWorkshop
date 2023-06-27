import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { Grid, Divider, Card, Rating, Container, Table } from "semantic-ui-react";
import "./carWorkshopsPage.css";

const JSON_HEADERS = {
  "Content-Type": "application/json",
};

export function ViewCarWorkshop() {
  const params = useParams();
  const [carWorkshop, setCarWorkshop] = useState({});
  const [repairman, setRepairman] = useState([]);

  useEffect(() => {
    fetch(`/api/v1/carWorkshops/${params.id}`)
      .then((response) => response.json())
      .then((data) => {
        setCarWorkshop(data);
        fetch(`/api/v1/repairmans/${params.id}`)
          .then((response) => response.json())
          .then((repairmanData) => {
            setRepairman(repairmanData);
          });
      });
  }, [params.id]);

  return (
    <div>
      <Container>
        <Table className="mt-5">
          <Table.Header>
            <Table.Row>
              <Table.HeaderCell>Serviso pavadinimas</Table.HeaderCell>
              <Table.HeaderCell>Adresas</Table.HeaderCell>
              <Table.HeaderCell>Vadovas</Table.HeaderCell>
            </Table.Row>
          </Table.Header>
          <Table.Body>
            <Table.Row>
              <Table.Cell>{carWorkshop.title}</Table.Cell>
              <Table.Cell>{carWorkshop.address}</Table.Cell>
              <Table.Cell>{carWorkshop.manager}</Table.Cell>
            </Table.Row>
          </Table.Body>
        </Table>

        <Container className="carWorkshops mt-5">
          <Grid columns={3} doubling stackable>
            <Grid.Row>
              {repairman.map((person) => (
                <Grid.Column key={person.id}>
                  <Card fluid className="mt-5 carWorkshops card">
                    <Card.Content>
                      <Card.Header>
                        {person.name} {person.surname}
                      </Card.Header>
                      <Card.Meta>Specializacija - {person.workScope}</Card.Meta>
                      <Card.Description>{person.city}</Card.Description>
                      <Card.Description>
                        Rating -
                        <Rating icon="star" defaultRating={person.rating} maxRating={5} disabled />
                      </Card.Description>
                    </Card.Content>
                  </Card>
                </Grid.Column>
              ))}
            </Grid.Row>
          </Grid>
        </Container>
      </Container>
    </div>
  );
}
