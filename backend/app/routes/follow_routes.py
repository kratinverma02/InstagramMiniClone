from flask import Blueprint, jsonify
from flask_jwt_extended import jwt_required, get_jwt_identity
from ..extensions import db
from ..models.user import User

follow_bp = Blueprint("follow", __name__, url_prefix="/follow")

@follow_bp.route("/<int:user_id>", methods=["POST"])
@jwt_required()
def follow(user_id):
    current = User.query.get(get_jwt_identity())
    target = User.query.get(user_id)
    current.follow(target)
    db.session.commit()
    return jsonify(message="Followed")
