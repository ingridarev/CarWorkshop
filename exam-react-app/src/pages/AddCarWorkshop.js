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
  const [address, setAddress] = useState("");
  const [manager, setManager] = useState([]);
  const [carWorkshop, setCarWorkshop] = useState([]);

  const listUrl = useHref("/carWorkshops");
  const [hide, setHide] = useState(false);

  const createCarWorkshop = () => {
    fetch("/api/v1/carWorkshops", {
      method: "POST",
      headers: JSON_HEADERS,
      body: JSON.stringify({
        title,
        address,
        manager,
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
              <label>Serviso pavadinimas:</label>
              <input
                placeholder="Serviso pavadinimas"
                value={title}
                onChange={(e) => setTitle(e.target.value)}
              />
            </Form.Field>
            <Form.Field>
              <label>Adresas:</label>
              <input
                placeholder="Adresas"
                value={address}
                onChange={(e) => setAddress(e.target.value)}
              />
            </Form.Field>
            <Form.Field>
              <label>Vadovas:</label>
              <input
                placeholder="Vadovas"
                value={manager}
                onChange={(e) => setManager(e.target.value)}
              />
            </Form.Field>
            <Button type="submit" primary style={{ color: 'black', backgroundColor: 'transparent', border: '1px solid black' }} onClick={createCarWorkshop}>
              Sukurti
            </Button>
          </Form>
        </Grid.Column>
        <Grid.Column width={5}></Grid.Column>
      </Grid>
    </div>
  );
}
