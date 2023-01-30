import { Container } from "react-bootstrap";
import { Link } from "react-router-dom";
import { useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
export default function Navbar() {
  const getdata = useSelector((state) => state.cartreducer.carts);
  // console.log(getdata);
  const navigate = useNavigate();

  const auth = () => {
    if (sessionStorage.length !== 0) {
      sessionStorage.clear();
      toast.success("Successfully Logged out");
      navigate("/home");
    } else {
      navigate("/login");
    }
  };
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-success">
      <Container>
        <Link className="navbar-brand p-2" to="/home">
          GMS
        </Link>
        <button
          className="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon" />
        </button>
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav mr-auto">
            <li className="nav-item active">
              <Link className="nav-link" to="/home">
                Home
              </Link>
            </li>
            <li className="nav-item active">
              <Link className="nav-link" to="/searchedProducts">
                Search Products
              </Link>
            </li>
          </ul>
          <ul className="navbar-nav">
            {sessionStorage["c_email"] ? (
              <div className="d-flex">
                <li className="nav-item active">
                  <Link className="nav-link" to="/cart">
                    My Cart
                  </Link>
                </li>
                <li className="nav-item active">
                  <span className="btn btn-warning badge badge-pill badge-light">
                    {getdata.length}
                  </span>
                </li>
              </div>
            ) : (
              <li></li>
            )}
          </ul>
          <ul className="navbar-nav position-absolute top-0 end-0 me-5 mt-2">
            <li className="nav-item active mr-3">
              {sessionStorage["token"] ? (
                <button className="btn btn-warning me-3">
                  Welcome,{" "}
                  {sessionStorage["c_fname"] + " " + sessionStorage["c_lname"]}
                </button>
              ) : null}

              <button className="btn btn-danger" onClick={() => auth()}>
                {sessionStorage["token"] ? " Logout" : "Login"}
              </button>
            </li>
          </ul>
        </div>
      </Container>
    </nav>
  );
}
