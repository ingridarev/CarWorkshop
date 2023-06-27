import { useEffect, useState } from "react";
import { useHref } from "react-router-dom";
import { Button, Form, Card } from "react-bootstrap";

export function CreateNewCarWorkshop() {
  const [title, setTitle] = useState("");
  const [text, setText] = useState("");
  const [titleError, setTitleError] = useState("Negali būti tuščias!");
  const [titles, setTitles] = useState([]);
  const [formValid, setFormValid] = useState(false)

  const listUrl = useHref("/");

  useEffect(() => {
    if (titleError) {
      setFormValid(false)
    } else {
      setFormValid(true)
    }
  }, [titleError])

  const titleHandler = (e) => {
    setTitle(e.target.value);
    if (e.target.value.length < 2 || e.target.value.length > 100) {
      setTitleError("Įveskite nuo 2 iki 100 simbolių!");
      document.getElementById("title").style.borderColor = "red";
      if (!e.target.value) {
        setTitleError("Negali būti tuščias!");
      }
    } else {
      setTitleError("");
      document.getElementById("title").style.borderColor = "#c7c5c5";
    }
    if (titles.includes(e.target.value)) {
      setTitleError("Straipsnis su šia antrašte jau publikuotas!");
    }
  };

  useEffect(() => {
    fetch("/api/v1/blogposts")
      .then((response) => response.json())
      .then((jsonResponse) => {
        const allTitles = jsonResponse.map((res) => res.title);
        setTitles(allTitles);
      });
  }, []);

  const clear = () => {
    setTitle("");
    setText("");
  };

  const applyResult = (result) => {
    if (result.ok) {
      clear();
      let info = result.json()
        .then((jsonResponse) => (window.location = listUrl));
    } else {
      window.alert("Nepavyko sukurt: " + result.status);
    }
  };

  const createBlogPost = () => {
    fetch("/api/v1/blogposts", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        title,
        text,
      }),
    }).then(applyResult);
  };

  return (
    <div className="d-grid justify-content-md-center">
      <Card className="p-2 mt-5 bg-light" style={{ width: "50rem" }}>
        <fieldset id="create-blogPost">
          <legend className="text-center">Sukurti naują įrašą</legend>
          <Form>
            <Form.Group className="mb-3">
              {titleError && <div style={{ color: "red" }}>{titleError}</div>}
              <Form.Label>Įrašo pavadinimas</Form.Label>
              <Form.Control
                type="text"
                id="title"
                value={title}
                onChange={(e) => titleHandler(e)}
              />
            </Form.Group>
            <Form.Group className="mb-3">
              <Form.Label>Tekstas</Form.Label>
              <Form.Control
                as="textarea"
                rows={3}
                id="text"
                value={text}
                onChange={(e) => setText(e.target.value)}
              />
            </Form.Group>
            <Button variant="dark" disabled={titleError} onClick={createBlogPost}>
              Paskelbti
            </Button>
          </Form>
        </fieldset>
      </Card>
    </div>
  );
}
