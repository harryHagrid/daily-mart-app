import React, { useState, useEffect } from 'react';
import "../../styles/AdminCategory.css";
import axios from 'axios';
import ToastMessage from '../../components/ToastMessage';

function EditCategoryForm(props) {

    const [category, setCategory] = useState({
        cid: 0,
        name: ""
    });
    const [message, setMessage] = useState('');

    const [showResponseMessage, setShowResponseMessage] = useState(false);
    

    const { editCategory } = props

    const changeName = (e) => {
        let updatedCategory = {
            cid: category.cid,
            name: e.target.value
        }
        setCategory(updatedCategory)
    }

    useEffect(() => {
        console.log(props);

        setCategory(editCategory)

    }, [])


    const editCategorySubmit = (e) => {
        e.preventDefault();

        console.log(category);
        let updatedCategory = category;

        if (updatedCategory.name === editCategory.name) {
            

        } else {
            axios.put('http://localhost:8082/category/', updatedCategory)
                .then(response => {
                    // sending the props back to the parent
                    setMessage(response.data.message);
                    setShowResponseMessage(true);

                })
                .catch(error => {
                    console.log(error);
                    setShowResponseMessage(true);

                })


            setCategory(
                {
                    cid: 0,
                    name: ''
                }
            );
        }



    }

    const goToCategoryList = () => {

        props.goToCategoryList();

    }
    return (
        <div>

            <h4><i className="fas fa-edit"></i>&nbsp;Edit Category</h4>
            <div className="back-button">
                <button type="button" className="btn btn-dark btn-sm" onClick={goToCategoryList}>Back</button>
            </div>
            <hr />
            {
                showResponseMessage ? (
                    <div>
                        <ToastMessage stopTime="6000" response={message} required={false} />
                    </div>
                ) : (
                        <div className="add-category">

                            <form onSubmit={editCategorySubmit}>
                                <div className="form-group">
                                    <label>
                                        <h5>Name of the Category</h5>
                                    </label>
                                    <input type="text" value={category.name} required className="form-control" id="categoryName" aria-describedby="categoryName" placeholder="Enter the name of the category" onChange={changeName} />
                                    <small id="emailHelp" className="form-text text-muted">Provide new unique category name.</small>

                                </div>


                                <div className="add-category-action">
                                    <button type="submit" className="btn btn-primary">Add</button>
                                </div>

                                



                            </form>


                        </div>
                    )
            }


        </div>


    );
}

export default EditCategoryForm;