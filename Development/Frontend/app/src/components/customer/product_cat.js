import { Link } from "react-router-dom";
import fruit_cat from "../../img/customer/fruit_cat.jpg";

export default function ProductCat(props) {
  return (
    <div
      className="card"
      style={{
        width: "15rem",
        margin: "12px",
        textAlign: "center",
      }}
    >
      <img src={fruit_cat} className="card-img-top" alt="" />
      <div className="card-body">
        <h5 className="card-title">{props.p_cat.cat_name}</h5>
        <p className="card-text">{props.p_cat.cat_desc}</p>

        <Link
          to="/producthome"
          state={{
            catid: props.p_cat.cat_id,
          }}
          className="btn btn-success"
        >
          Show Products
        </Link>
      </div>
    </div>
  );
}
