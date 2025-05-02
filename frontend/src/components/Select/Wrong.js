// React Imports
import Alert from 'react-bootstrap/Alert';

// Style Imports
import '../../style/Wrong.css';

const Wrong = ({ show, setShow }) => {
  return (
    <>
      <Alert 
        className="alert"
        show={show}
        onClick={() => setShow(false)}>
        <Alert.Heading>ROOM DOESN'T EXIST, ASK FOR THE ROOM # AGAIN</Alert.Heading>
      </Alert>
    </>
  );
};

export default Wrong;