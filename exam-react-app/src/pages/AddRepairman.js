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
  const [title, setTitle] = useState("");
  const [quantity, setQuantity] = useState("");
  const [meals, setMeals] = useState([]);
  const [menu, setMenu] = useState(id);

  const listUrl = useHref(`/carWorkshops/${id}`);
  const [hide, setHide] = useState(false);

  const createMeal = () => {
    fetch(`/api/v1/repairmans/${id}`, {
      method: "POST",
      headers: JSON_HEADERS,
      body: JSON.stringify({
        title,
        quantity,
        menu: id,
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
              <label>Patiekalo pavadinimas</label>
              <input
                placeholder="Patiekalo pavadinimas"
                value={title}
                onChange={(e) => setTitle(e.target.value)}
              />
            </Form.Field>
            <Form.Field>
              <label>Kiekis</label>
              <input
                placeholder="Kiekis"
                value={quantity}
                onChange={(e) => setQuantity(e.target.value)}
              />
            </Form.Field>

            <Button type="submit" basic style={{ color: 'black', backgroundColor: 'transparent', border: '1px solid black' }} onClick={createMeal}>
              Sukurti
            </Button>
          </Form>
        </Grid.Column>
        <Grid.Column width={5}></Grid.Column>
      </Grid>
    </div>
  );
}
