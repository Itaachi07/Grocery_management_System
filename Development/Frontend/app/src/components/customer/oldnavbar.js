import { Link, useLocation } from "react-router-dom";
import Slider from "./slider";
// import { useEffect } from "react";

const OldNavbar = () => {
  // let location = useLocation();
  // useEffect(() => {
  //   // console.log(location.pathname);
  // }, [location]);

  return (
    <div>
      <nav
        className="navbar navbar-expand-lg py-2"
        style={{
          fontSize: "130%",
        }}
      >
        <div className="container-fluid">
          <div className="collapse navbar-collapse" id="navbarSupportedContent">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item">
                <Link
                  className="nav-link active"
                  to="/home"
                  style={{ color: "#11851b", fontWeight: "bold" }}
                >
                  <img
                    src="logo.png"
                    style={{ height: "90px", margin: "auto" }}
                  ></img>
                </Link>
              </li>

              <li className="nav-item" style={{ marginBlock: "auto" }}>
                <form className="d-flex" role="search">
                  <input
                    className="form-control me-2"
                    type="search"
                    style={{
                      borderRadius: "5vh",
                      width: "35vw",
                      marginLeft: "35vh",
                      textAlign: "center",
                    }}
                    placeholder="Search Products here..."
                  />

                  <button
                    className="btn btn-warning"
                    type="submit"
                    style={{
                      width: "20%",
                      borderRadius: "5vh",

                      fontSize: "20px",
                    }}
                  >
                    Search
                  </button>
                </form>
              </li>
            </ul>

            <ul className="nav navbar-nav navbar-right">
              <li className="nav-item">
                <Link
                  style={{
                    color: "black",
                    borderRadius: "5wh",
                    backgroundColor: "lightgreen",
                    marginRight: "40px",
                  }}
                  className="nav-link active"
                  data-bs-toggle="offcanvas"
                  data-bs-target="#offcanvasScrolling"
                  aria-current="page"
                  to="/cart"
                >
                  My Cart
                  <img src="cart.png" style={{ width: "40px" }}></img>
                </Link>
              </li>
              <li className="nav-item">
                <Link
                  style={{ color: "#11851b", fontWeight: "bold" }}
                  className="nav-link active"
                  aria-current="page"
                  to="/login"
                >
                  Login
                </Link>
              </li>
              <li className="nav-item">
                {/* <Link
                  style={{ color: "#11851b", fontWeight: "bold" }}
                  className="nav-link active"
                  aria-current="page"
                  to="/logout"
                >
                  Logout
                </Link> */}
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <Slider />
    </div>
  );
};

export default Navbar;
