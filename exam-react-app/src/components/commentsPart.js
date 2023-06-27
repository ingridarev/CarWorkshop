import { useState, useEffect } from "react";
import { Button, Form, Card } from "react-bootstrap";
import { useParams } from "react-router-dom";


export function CommentsPart() {
  const params = useParams();
  const [comments, setComments] = useState([]);
  const [author, setAuthor] = useState("");
  const [text, setText] = useState("");
  const [isActive, setIsActive] = useState(false)

  useEffect(() => {
    fetch(`/api/v1/comments/all/${params.id}`)
      .then((response) => response.json())
      .then(setComments);
  }, [params.id, isActive]);

  const clear = () => {
    setAuthor("");
    setText("");
    setIsActive(false);       
}

const applyResult = (result) => {
    if (result.ok) {
        clear();
    } else {
        window.alert("Nepavyko sukurt: " + result.status);
    }
};

const createComment = () => {
    fetch(
        `/api/v1/comments/${params.id}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                author,
                text                    
            })
    }).then(applyResult)
    .then(setIsActive(true))        
};


  return (
    <div className="mb-5">      
      <Card className="p-2 my-4 bg-light" style={{ width: "20rem" }}>
        <fieldset id="create">
          <legend>Naujas Komentaras</legend>
           <Form>
            <Form.Group className="mb-3">
              <Form.Label>Autorius</Form.Label>
              <Form.Control
                type="text"
                id="author"
                value={author}
                onChange={(e) => setAuthor(e.target.value)}
              />
            </Form.Group>
            <Form.Group className="mb-3">
              <Form.Label>Komentaras</Form.Label>
              <Form.Control
                as="textarea"
                rows={3}
                id="text"
                value={text}
                onChange={(e) => setText(e.target.value)}
              />
            </Form.Group>
            <Button variant="dark" onClick={createComment}>
              Paskelbti
            </Button>
          </Form>
        </fieldset>
      </Card>
      {comments.map((comment) => (
      <Card key={comment.id} style={{ width: "20rem" }} className="mt-2">        
      <Card.Header>{comment.createdDate}</Card.Header>
      <Card.Body>
        <Card.Title>{comment.author}</Card.Title>
        <Card.Text>
        {comment.text}
        </Card.Text>        
      </Card.Body>
    </Card>
    ))}      
    </div>
  );
}
