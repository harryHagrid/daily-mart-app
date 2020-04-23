import React, { useState, useEffect } from 'react';
import "../../styles/AdminCategory.css";
import axios from 'axios';
import AddCategoryForm from './AddCategoryForm';
import EditCategoryForm from './EditCategoryForm';
import ToastMessage from '../../components/ToastMessage';

function AdminCategoryList() {

    const [categoryList, setCategoryList] = useState([]);
    const [isLoadingCategory, setIsLoadingCategory] = useState(false);
    const [editCategoryData, setEditCategoryData] = useState({
        cid: 0,
        name: ""
    });
    const [showEditForm, setShowEditForm] = useState(false);
    const [showDeleteResponseMsg, setShowDeleteResponseMsg] = useState({
        success: false,
        message: ""
    });


    // function to get back the response from addCategoryForm
    const addCategory = response => {

        if (response.data.success) {
            fetchCategoryList()
        }

    }

    // to fetch the category list
    const fetchCategoryList = async () => {
        setIsLoadingCategory(true);

        const result = await axios.get('http://localhost:8082/category/');

        setCategoryList(result.data.body);
        setIsLoadingCategory(false)


    }

    useEffect(() => {

        fetchCategoryList();

    }, [])


    const editCategoryBtn = (item) => {
        console.log(item);

        setEditCategoryData(item);
        setShowEditForm(true);
        console.log(editCategoryData);

    }

    const deleteCategoryBtn = async (item) => {
        console.log(item);

        await axios.delete(`http://localhost:8082/category/${item.cid}`)
            .then(response => {
                fetchCategoryList();
                setShowDeleteResponseMsg(response.data);
                console.log(response);

            }, error => {
                fetchCategoryList();
                setShowDeleteResponseMsg(error.data);
            })

    }

    const editCategoryResponse = response => {
        console.log(response);

        setShowEditForm(false);
        fetchCategoryList();


    }

    const goToCategoryList = e => {
        setShowEditForm(false);
        fetchCategoryList();
    }

    /**
     * This effect does a couple of interesting things. 
     * First, let’s note the second parameter to the useEffect invocation. 
     * It’s [] or an empty array. 
     * This indicates that there are no dependencies for this useEffect hook, 
     * which means it will only run once. 
     * The second thing to note is that the useEffect callback cannot be asynchronous. 
     * Instead, React recommends declaring an async function in your callback and executing it immediately. 
     * This is exactly what we’re doing above. Let’s add this snippet to our component.
     */


    return (
        <div className="admin-category">
            <div>

                <AddCategoryForm addCategory={addCategory} />

            </div>

            <div className="category-list">


                {
                    isLoadingCategory ?
                        (

                            <div className="loading-category">
                                Loading categories list...
                            </div>
                        )
                        :
                        (

                            showEditForm ? (
                                <EditCategoryForm editCategory={editCategoryData} editCategoryResponse={editCategoryResponse} goToCategoryList={goToCategoryList} />
                            )
                                : (
                                    <div>

                                        <h4><i className="fas fa-list"></i>&nbsp;Category List
                                   <span style={{ fontSize: "15px" }}> ({categoryList.length + 1} results found)</span>
                                        </h4>
                                        <hr />
                                        {
                                            showDeleteResponseMsg.message.length > 0 ?
                                                ( <div><ToastMessage stopTime="6000" response={showDeleteResponseMsg.message} required={true} /></div>)
                                                : (<div><ToastMessage stopTime="6000" response={showDeleteResponseMsg.message} required={true} /></div>)
                                        }
                                        <div className="row">

                                            {categoryList.map(item => (
                                                <div className="col-md-3 category-item" key={item.cid}>

                                                    <div className="card category-card ">
                                                        <div className="card-body">
                                                            <div className="card-title" >
                                                                <h6 style={{ color: "#0165d0" }}>
                                                                    <i className="fas fa-circle fa-sm" />
                                                         &nbsp;&nbsp;{item.name}
                                                                </h6>
                                                            </div>
                                                            <button className="btn btn-dark btn-sm" onClick={() => editCategoryBtn(item)} ><i className="fas fa-edit" />&nbsp; Edit</button> &nbsp;
                                                            <button className="btn btn-danger btn-sm" onClick={() => deleteCategoryBtn(item)}><i className="fas fa-trash" /> &nbsp; Delete</button>

                                                        </div>


                                                    </div>

                                                </div>
                                            ))}
                                        </div>
                                    </div>
                                )


                        )
                }
            </div>




        </div>
    );
}

export default AdminCategoryList;