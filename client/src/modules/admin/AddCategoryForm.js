import React, { useState, useEffect } from 'react';
import "../../styles/AdminCategory.css";
import axios from 'axios';
import ToastMessage from '../../components/ToastMessage';

function AddCategoryForm(props) {

    const [category, setCategory] = useState('');
    const [message, setMessage] = useState('');

    const changeName = (e) => {

        setCategory(e.target.value)
    }


    const addCategory = (e) => {
        e.preventDefault();

        console.log(category)
        let categoryPost = {
            name: category
        }

        axios.post('http://localhost:8082/category/', categoryPost)
            .then(response => {
                // sending the props back to the parent
                props.addCategory(response);
                setMessage(response.data.message);
                

            })
            .catch(error => {
                console.log(error);

            })


        setCategory('');

    }

    return (
        <div className="add-category">
            <h4><i className="fas fa-plus-circle"></i>&nbsp;Add New Category</h4>
            <hr />
            <form onSubmit={addCategory}>
                <div className="form-group">
                    <label>
                        <h5>Name of the Category</h5>
                    </label>
                    <input type="text" value={category} required className="form-control" id="categoryName" aria-describedby="categoryName" placeholder="Enter the name of the category" onChange={changeName} />
                    <small id="emailHelp" className="form-text text-muted">Provide new unique category name.</small>
                    <ToastMessage stopTime="6000" response= {message} />
                </div>


                <div className="add-category-action">
                    <button type="submit" className="btn btn-primary">Add</button>
                </div>

                <div className="add-category-action">
                    <button type="reset" className="btn btn-warning">Clear</button>
                </div>



            </form>
        </div>
    );
}

export default AddCategoryForm;