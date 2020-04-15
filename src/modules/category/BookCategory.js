import React from 'react';

import slide1 from '../../images/book1.jpg'
import CardItem from '../../components/CardItem';
class BookCategory extends React.Component {


    render() {
        return (
            <div>
                <nav aria-label="breadcrumb">
                    <ol className="breadcrumb">
                        <li className="breadcrumb-item"><a href="/"><i className="fas fa-home"></i></a></li>
                        <li className="breadcrumb-item active" aria-current="page">Books</li>
                    </ol>
                </nav>
                <div className="container">
                    <div className="row">
                        <div className="col-md-2">
                            <ul className="nav flex-column">
                                <li className="nav-item">
                                    <a className="nav-link active" href="#">Active</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link" href="#">Link</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link" href="#">Link</a>
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                                </li>
                            </ul>
                        </div>
                        <div className="col-md-9">
                            <div className="row">
                                <CardItem />
                                <CardItem />
                                <CardItem />


                            </div>

                            <div className="row">
                                <CardItem />
                                <CardItem />
                                <CardItem />

                            </div>

                            <div className="row">
                                <CardItem />
                                <CardItem />
                                <CardItem />


                            </div>

                            <div className="row">
                                <CardItem />
                                <CardItem />
                                <CardItem />


                            </div>

                        </div>
                    </div>
                </div>



            </div>
        )
    }

}

export default BookCategory