import { Link, useLocation } from "react-router-dom";
import { useEffect } from "react";

const NavbarSeller = () => {
  let location = useLocation();
  useEffect(() => {
    console.log(location.pathname);
  }, [location]);

  return (
    <div>
      <nav
        className="navbar navbar-expand-lg py-2"
        style={{
          fontSize: "130%",
        }}
      >
        <div className="container-fluid">
          <div
            className="collapse navbar-collapse"
            style={{ backgroundColor: "#11851b" }}
            id="navbarSupportedContent"
          >
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
                    alt=""
                  ></img>
                </Link>
              </li>

              <li className="nav-item">
                <Link className="nav-link active" to="/sorder">
                  My Orders
                </Link>
              </li>

              <li className="nav-item">
                <Link className="nav-link active" to="/sproduct">
                  Listed Products
                </Link>
              </li>

              <li className="nav-item">
                <Link className="nav-link active" to="/selleraddproduct">
                  Add Product
                </Link>
              </li>

              <li className="nav-item">
                <Link
                  style={{ fontWeight: "bold" }}
                  className="nav-link active"
                  aria-current="page"
                  to="/home"
                >
                  Logout
                </Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
  );
};

export default NavbarSeller;
