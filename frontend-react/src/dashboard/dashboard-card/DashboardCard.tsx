import React from 'react';
import './DashboardCard.css';
import Card from "../../shared/layout/card/Card";
import Currency from "../../shared/formatting/Currency";
import { ServiceSpend } from "../ServiceSpend";

function DashboardCard({ service, spending }: ServiceSpend) {
  return (
    <Card title={service} subtitle="Spending in March 2015">
      <div className="Dashboard-card-content">
        <h2 className="Card-value">
          <Currency value={spending} currency="£"/>
        </h2>
      </div>
    </Card>
  )
}

export default DashboardCard;
