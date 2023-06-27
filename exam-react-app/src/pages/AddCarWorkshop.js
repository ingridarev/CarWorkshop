import { useState, useContext, useEffect } from "react";
import { useHref} from "react-router-dom";
import { Button, Modal, Form, Select, Grid, TextArea } from "semantic-ui-react";
import AuthContext from "../AuthContext";

const JSON_HEADERS = {
  "Content-Type": "application/json",
};

export function AddCarWorkshop() {
  const { appState } = useContext(AuthContext);
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [meals, setMeals] = useState([]);
  const [menus, setMenus] = useState([]);

  const listUrl = useHref("/menus");
  const [hide, setHide] = useState(false);

  const createMenu = () => {
    fetch("/api/v1/carWorkshops", {
      method: "POST",
      headers: JSON_HEADERS,
      body: JSON.stringify({
        title,
        description,
        meals,
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
              <label>Meniu pavadinimas</label>
              <input
                placeholder="Meniu pavadinimas"
                value={title}
                onChange={(e) => setTitle(e.target.value)}
              />
            </Form.Field>
            <Form.Field>
              <label>Aprašymas</label>
              <TextArea
                placeholder="Aprašymas"
                value={description}
                onChange={(e) => setDescription(e.target.value)}
              />
            </Form.Field>
            <Button type="submit" primary onClick={createMenu}>
              Sukurti
            </Button>
          </Form>
        </Grid.Column>
        <Grid.Column width={5}></Grid.Column>
      </Grid>
    </div>
  );
}
