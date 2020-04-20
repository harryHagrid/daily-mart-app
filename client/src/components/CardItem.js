import React from 'react'
import slide1 from '../images/book1.jpg'
import '../styles/CardItem.css'

function CardItem(props) {

    const { title, price, rating, descripton } = props;

    return (
        <div >
            <div className="card" style={{ width: "17rem", margin: "5px" }}>
                <img src={slide1} class="card-img-top" alt="..." />
                <div class="card-body">
                    <h5 className="card-title">{title}
                        <span style={{ fontSize: "18px", color: "red", float: "right" }}>
                            <i className="fas fa-rupee-sign"></i> {price}
                        </span>


                    </h5>
                    <p style={{ float: "right" }}>
                        <span className="fas fa-star checked"></span>
                        <span className="fas fa-star checked"></span>
                        <span className="fas fa-star checked"></span>
                        <span className="fa fa-star"></span>
                        <span className="fa fa-star"></span>
                    </p>
                    <hr />
                    <p className="card-text"> {descripton.slice(0, 25).concat('...')}</p>
                    <div className="row">

                        <a href="#" className="btn btn-success" style={{ margin: "5px" }}> View Details</a>

                        <a href="#" className="btn btn-warning" style={{ margin: "5px" }}> <i className="fas fa-cart-plus"></i> Add to cart</a>
                    </div>

                </div>
            </div>
        </div>
    )
}


export default CardItem

CardItem.defaultProps = {
    title: "Product",
    price: "NA",
    rating: 0,
    descripton: "No information available"
}