import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { useLocation, useNavigate } from "react-router-dom";
import { ClearCart } from "../../redux/actions/action";
import { toast } from "react-toastify";

import "../../css/customer/payment.css";
export default function Payment() {
  const getdata = useSelector((state) => state.cartreducer.carts);

  const dispatch = useDispatch();
  const navigate = useNavigate();
  const location = useLocation();
  const price = location.state;

  const proceed = () => {
    toast.success("Order Placed Successfully");
    dispatch(ClearCart(getdata));
    navigate("/home");
  };
  return (
    <div className="container p-0 mt-5">
      <div className="card px-4">
        <p className="h8 py-3">Payment Details</p>
        <div className="row gx-3">
          <div className="col-12">
            <div className="d-flex flex-column">
              <p className="text mb-1">Person Name</p>
              <input
                className="form-control mb-3"
                type="text"
                placeholder="Your Card Name"
              />
            </div>
          </div>
          <div className="col-12">
            <div className="d-flex flex-column">
              <p className="text mb-1">Card Number</p>
              <input
                className="form-control mb-3"
                type="text"
                placeholder="1234 5678 4355 5678"
              />
            </div>
          </div>
          <div className="col-6">
            <div className="d-flex flex-column">
              <p className="text mb-1">Expiry</p>
              <input
                className="form-control mb-3"
                type="text"
                placeholder="MM/YYYY"
              />
            </div>
          </div>
          <div className="col-6">
            <div className="d-flex flex-column">
              <p className="text mb-1">CVV/CVC</p>
              <input
                className="form-control mb-3 pt-2 "
                type="password"
                placeholder="***"
              />
            </div>
          </div>
          <div className="col-12" onClick={proceed}>
            <div className="btn btn-primary mb-3">
              <span className="ps-3">Make Payment ???{price.price}</span>
              <span className="fas fa-arrow-right" />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
