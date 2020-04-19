import React from 'react';
import AppHeader from '../components/App-header';
import slide1 from '../images/mobile-homepage.jpg';
import BookCategory from './category/BookCategory';

function HomePage() {


    return (
        <div>
            
            <div id="carouselExampleCaptions" className="carousel slide" data-ride="carousel">
                <ol className="carousel-indicators">
                    <li data-target="#carouselExampleCaptions" data-slide-to="0" className="active"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
                </ol>
                <div className="carousel-inner">
                    <div className="carousel-item active">
                        <img src={slide1} className="d-block w-100 Carousel-image" alt="..." />
                        <div className="carousel-caption d-none d-md-block">
                            <h5>Online Shopping</h5>
                            <p>Great Deals at affordable prices.</p>
                        </div>
                    </div>
                    <div className="carousel-item">
                        <img src={slide1} className="d-block w-100 Carousel-image" alt="..." />
                        <div className="carousel-caption d-none d-md-block">
                            <h5>Online Shopping</h5>
                            <p>Great Deals at affordable prices.</p>
                        </div>
                    </div>
                    <div className="carousel-item">
                        <img src={slide1} className="d-block w-100 Carousel-image" alt="..." />
                        <div className="carousel-caption d-none d-md-block">
                            <h5>Online Shopping</h5>
                            <p>Great Deals at affordable prices.</p>
                        </div>
                    </div>
                </div>
                <a className="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                    <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span className="sr-only">Previous</span>
                </a>
                <a className="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                    <span className="carousel-control-next-icon" aria-hidden="true"></span>
                    <span className="sr-only">Next</span>
                </a>
            </div>



            
        </div>
    )
}

export default HomePage