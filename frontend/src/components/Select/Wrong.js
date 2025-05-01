import Alert from 'react-bootstrap/Alert';
import Button from 'react-bootstrap/Button';

const Wrong = ({ tex, setVar }) => {
  return (
    <>
      <Alert show={tex} variant="success">
        <Alert.Heading>No such room</Alert.Heading>
          <Button onClick={() => setVar(false)} variant="outline-success">
            Ask your friend again
          </Button>
      </Alert>
    </>
  );
};

export default Wrong;