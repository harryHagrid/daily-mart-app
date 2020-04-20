import React from 'react';
import { Route } from 'react-router-dom';
import BookCategory from '../modules/category/BookCategory';
import HomePage from '../modules/Homepage';
import AdminComponent from '../modules/admin/AdminComponent';
import '../styles/AppHeader.css'

function AppHeader() {
    return (
        <div>
            <nav className="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
                <a className="navbar-brand" href="#">Daily Mart</a>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>

                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item active">
                            <a className="nav-link" href="/"><i className="fas fa-home"></i>
                                <span className="sr-only">(current)</span>
                            </a>
                        </li>
                        <li className="nav-item">

                            <a className="nav-link" href="/admin">Admin</a>
                        </li>
                        <li className="nav-item dropdown">
                            <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Category
                            </a>
                            <div className="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a className="dropdown-item" href="/books">Books</a>
                                <a className="dropdown-item" href="#">Mobiles</a>
                                <div className="dropdown-divider"></div>
                                <a className="dropdown-item" href="#">Grocery</a>
                            </div>
                        </li>

                        <li className="nav-item">
                            <form className="form-inline my-2 my-lg-0">
                                <input className="form-control mr-sm-2" type="search" placeholder="Search Items" aria-label="Search" />
                                <button className="btn btn-outline-success my-2 my-sm-0 search-btn" type="submit">
                                    <i className="fas fa-search" />&nbsp;    Search
                                </button>
                            </form>
                        </li>

                    </ul>
                    <div className="header-right">

                        <button type="button" className="btn btn-success">
                            <i className="fas fa-heart" />&nbsp; My Wishlist
                            <span className="sr-only">wishlist items</span>
                        </button>
                    </div>

                    <div className="header-right">
                    <button type="button" className="btn btn-success">
                        <i className="fas fa-shopping-cart" />&nbsp; My Cart <span className="badge badge-light">9</span>
                        <span className="sr-only">cart items</span>
                    </button>
                    </div>
                    
                    <button type="button" className="btn btn-dark">
                        <i className="fas fa-user" />&nbsp; Sign in

                        </button>

                </div>
            </nav>

            <Route path="/books" component={BookCategory} />
            <Route path="/" exact component={HomePage} />
            <Route path="/admin" component={AdminComponent} />

        </div>
    );

}



export default AppHeader;