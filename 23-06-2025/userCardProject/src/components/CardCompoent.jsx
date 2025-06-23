
import React from 'react';
import './Card.css';

function Card({ title, subtitle, image }) {
  return (
    <div className="card">
      {image && <img src={image} alt={title} className="card-image" />}
      <div className="card-body">
        <h2 className="card-title">{title}</h2>
        <p className="card-content">{subtitle}</p>
      </div>
    </div>
  );
}

export default Card;
