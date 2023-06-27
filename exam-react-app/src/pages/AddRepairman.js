import { useState, useContext, useEffect } from "react";
import { useHref, useParams } from "react-router-dom";
import { Button, Modal, Form, Select, Grid, TextArea } from "semantic-ui-react";
import AuthContext from "../AuthContext";

const JSON_HEADERS = {
  "Content-Type": "application/json",
};

export function AddRepairman() {
  const { appState } = useContext(AuthContext);
  const { id } = useParams();
  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [workScope, setWorkScope] = useState("");
  const [city, setCity] = useState("");
  const [rating, setRating] = useState("");

  const listUrl = useHref(`/carWorkshops/${id}`);
  const [hide, setHide] = useState(false);

  const createRepairman = () => {
    fetch(`/api/v1/repairmans/${id}`, {
      method: "POST",
      headers: JSON_HEADERS,
      body: JSON.stringify({
        name,
        surname,
        workScope,
        city,
        rating,
        carWorkshop: id,
      }),
    })
      .then(applyResult)
      .then(() => (window.location = listUrl));
  };

  const applyResult = (result) => {
    const clear = () => {
      setHide(true);
    };
    if (result.ok) {
      clear();
    } else {
      window.alert("Nepavyko sukurt: " + result.status);
    }
  };

  return (
    <div>
      <Grid columns={3}>
        <Grid.Column width={5}></Grid.Column>
        <Grid.Column width={6}>
          <Form>
            <Form.Field>
              <label>Vardas</label>
              <input
                placeholder="Vardas"
                value={name}
                onChange={(e) => setName(e.target.value)}
              />
            </Form.Field>
            <Form.Field>
              <label>Pavardė</label>
              <input
                placeholder="Pavardė"
                value={surname}
                onChange={(e) => setSurname(e.target.value)}
              />
            </Form.Field>
            <Form.Field>
              <label>Specializacija</label>
              <input
                placeholder="Specializacija"
                value={workScope}
                onChange={(e) => setWorkScope(e.target.value)}
              />
            </Form.Field>
            <Form.Field>
              <label>Miestas</label>
              <input
                placeholder="Miestas"
                value={city}
                onChange={(e) => setCity(e.target.value)}
              />
            </Form.Field>

            <Button
              type="submit"
              basic
              style={{
                color: "black",
                backgroundColor: "transparent",
                border: "1px solid black",
              }}
              onClick={createMeal}
            >
              Sukurti
            </Button>
          </Form>
        </Grid.Column>
        <Grid.Column width={5}></Grid.Column>
      </Grid>
    </div>
  );
}
