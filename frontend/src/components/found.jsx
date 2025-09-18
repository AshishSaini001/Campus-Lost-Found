import React, { useEffect, useState } from "react";
import axios from "axios";
import "./Found.css"; 

const Found = () => {
  const [foundItems, setFoundItems] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:9090/api/found-items")
      .then((response) => {
        setFoundItems(response.data);
      })
      .catch((error) => {
        console.error("Error fetching found items:", error);
      });
    console.log(foundItems);
  }, []);

  return (
    <div className="found-container">
      <h1 className="found-title">📦 Found Items</h1>
      <table className="found-table">
        <thead>
          <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Location</th>
            <th>Date</th>
          </tr>
        </thead>
        <tbody>
          {foundItems.map((item) => (
            <tr key={item.id}>
              <td>{item.name}</td>
              <td>{item.description}</td>
              <td>{item.location}</td>
              <td>{item.date}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Found;
